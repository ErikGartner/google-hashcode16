import java.util.*;

/**
 * Created by erik on 11/02/16.
 */
public class Solver2 {

    public Problem problem;

    public Solver2(Problem p) {
        this.problem = p;
    }

    public void solve() {
        for(Drone d: problem.droneList) {
            solve(d);
        }
    }

    public void solve(Drone d) {

        System.out.println("Solving for drone: " + d.id);
        while(d.availableAt < problem.maxTurns) {
            Order o = bestOrderFor(d);
            List<Product> productList = chooseProductFrom(d, o);
            List<Warehouse> warehouses = chooseWarehouses(d, productList, o);
            System.out.println("Deliver for drone: " + d.id);
            System.out.println("Deliver for drone at time: " + d.availableAt);
            deliver(warehouses, productList, o, d);
        }

        System.out.print(d.getCommandString());

    }

    private void deliver(List<Warehouse> warehouses, List<Product> productList, Order o, Drone d) {

        while(!productList.isEmpty()) {

            // Sort by distance
            Collections.sort(warehouses, new ClosestSorter(d));

            Warehouse w = warehouses.get(0);
            if(!w.take(productList, d, o)){
                warehouses.remove(w);
            }

        }

        for(Product p: d.inventory.keySet()) {
            Command c = new DeliverCommand(d, o, p, d.inventory.get(p));
            d.availableAt += c.getTime();
            d.commands.add(c);
        }

        d.inventory = new HashMap<>();
    }

    private List<Warehouse> chooseWarehouses(Drone d, List<Product> productList, Order o) {
        return new ArrayList<>(problem.warehouseList);
    }

    private List<Product> chooseProductFrom(Drone d, Order o) {
        int droneCapacity = 0;

        List<Product> products = new ArrayList<Product>();
        for (Product p : o.products.keySet()) {
            int count = o.products.get(p);

            for (int i = 0; i < count; i++) {
                if (p.weight + droneCapacity > d.maxPayload) {
                    return products;
                }
                products.add(p);  
                droneCapacity += p.weight;
            }
        }

        return products;
    }

    public Order bestOrderFor(Drone d) {        
        return problem.orderList.get(0);
    }

    class ClosestSorter implements Comparator<MapObject> {

        public MapObject point;

        public ClosestSorter(MapObject m) {
            point = m;
        }

        @Override
        public int compare(MapObject o1, MapObject o2) {
            int d1 = o1.distanceSq(point);
            int d2 = o2.distanceSq(point);
            return d1 -  d2;
        }
    }

}

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        while(d.availableAt < problem.maxTurns) {
            Order o = bestOrderFor(d);
            List<Product> productList = chooseProductFrom(d, o);
            List<Warehouse> warehouses = chooseWarehouses(d, productList, o);
            deliver(warehouses, productList, o, d);
        }

    }

    private void deliver(List<Warehouse> warehouses, List<Product> productList, Order o, Drone d) {

        while(!productList.isEmpty()) {

            // Sort by distance
            Collections.sort(warehouses, new ClosestSorter(d));

            Warehouse w = warehouses.get(0);
            if(!w.take(productList, d)) {
                warehouses.remove(w);
            }


            // go to each warehouse and pick products


        }

    }

    private List<Warehouse> chooseWarehouses(Drone d, List<Product> productList, Order o) {
    }

    private List<Product> chooseProductFrom(Drone d, Order o) {

    }

    public Order bestOrderFor(Drone d) {
        return null;
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
            return d1 - d2;
        }
    }

}

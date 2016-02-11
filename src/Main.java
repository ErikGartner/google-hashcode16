import java.util.*;

/**
 * Created by erik on 11/02/16.
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(args[0]);

        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int nbrDrones = sc.nextInt();
        int turns = sc.nextInt();
        int maxPayload = sc.nextInt();

        int nbrProducts = sc.nextInt();
        List<Product> productsList = new ArrayList<Product>(nbrProducts);
        for(int i = 0; i < nbrProducts; i++ ){
            productsList.add(new Product(sc.nextInt()););
        }

        int nbrWarehouses = sc.nextInt();
        List<Warehouse> warehouseList = new ArrayList<Warehouse>(nbrWarehouses);
        for(int i = 0; i < nbrWarehouses; i++ ){
            Warehouse w = new Warehouse(sc.nextInt(), sc.nextInt());
            Map<Product, Integer> inventory = new HashMap<Product, Integer>();
            w.inventory = inventory;

            for(int j = 0; j < nbrProducts; j++) {
                inventory.put(productsList.get(j), sc.nextInt());
            }
        }

        int nbrOrders = sc.nextInt();
        List<Order> orderList = new ArrayList<Order>(nbrOrders);
        for(int i = 0; i < nbrOrders; i++ ){
            Order o = new Order(sc.nextInt(), sc.nextInt());
            Map<Product, Integer> inventory = new HashMap<Product, Integer>();
            o.products = inventory;
            int n = sc.nextInt();
            for(int j = 0; j < n; j++) {
                int count = 0;
                Product p = productsList.get(sc.nextInt());
                if(inventory.containsKey(p)) {
                    count += inventory.get(p);
                }
                inventory.put(p, count + 1);
            }
        }

        List<Drone> droneList = new ArrayList<>(nbrDrones);
        for(int i = 0; i < nbrDrones; i++ ){
            Drone d = new Drone(warehouseList.get(0).r, warehouseList.get(0).c);
            droneList.add(d)
        }

        Problem p = new Problem(productsList, warehouseList, orderList, droneList);

    }

    public void solve() {
        System.out.println("Klart!");
    }


}

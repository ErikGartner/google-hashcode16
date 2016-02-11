import java.util.List;

/**
 * Created by erik on 11/02/16.
 */
public class Problem {

    public List<Drone> droneList;
    public List<Order> orderList;
    public List<Warehouse> warehouseList;
    public List<Product> productList;

    public Problem(List<Product> productsList, List<Warehouse> warehouseList, List<Order> orderList, List<Drone> droneList) {
        this.droneList = droneList;
        this.productList = productsList;
        this.warehouseList = warehouseList;
        this.orderList = orderList;
    }
}

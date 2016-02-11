import java.util.List;
import java.util.Map;

/**
 * Created by erik on 11/02/16.
 */
public class Warehouse extends MapObject{

    public int id;
    public Map<Product, Integer> inventory;

    public Warehouse(int r, int c) {
        super(r, c);
    }

    public boolean take(List<Product> productList, Drone d) {
    }
}

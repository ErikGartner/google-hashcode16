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
    	boolean change = false; 

    	for (int i = 0; i < productList.size(); i++) {
    		Product p = productList.get(i);
    		if (inventory.containsKey(p) && inventory.get(p) > 0) {
    			change = true;

    			// Add to drone
    			if (d.inventory.containsKey(p)) {
    				d.inventory.put(p, d.inventory.get(p)+1);
    			} else {
    				d.inventory.put(p, 1);
    			}

    			inventory.put(p, inventory.get(p)-1);
    			if (inventory.get(p) == 0) {
    				inventory.remove(p);
    			}

    			// Remove from productList
    			productList.remove(i);
    		}
    	}

    	return change;
    }
}

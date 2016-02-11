import java.util.HashMap;
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

    public boolean take(List<Product> productList, Drone d, Order o) {
    	boolean change = false; 
    	Map<Product, Integer> productCount = new HashMap<Product, Integer>();

    	for (int i = productList.size() - 1; i >= 0; i--) {
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

    			if (productCount.containsKey(p)) {
    				productCount.put(p, productCount.get(p)+1);
    			} else {
    				productCount.put(p, 1);
    			}

    			// Remove from productList
    			productList.remove(i);
    		}
    	}

    	// Add loadCommand
    	for (Product p : productCount.keySet()) {
    		LoadCommand lc = new LoadCommand(d, o, p, productCount.get(p), this);
    		d.commands.add(lc);
    		d.availableAt += lc.getTime();
    	}

    	return change;
    }
}

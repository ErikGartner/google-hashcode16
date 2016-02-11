import java.util.*;

/**
 * Created by erik on 11/02/16.
 */
public class Order extends MapObject {

	public int id;
	public int priority;
	Map<Product, Integer> products;

    public Order(int r, int c) {
        super(r, c);
    }

    public int compareTo(Object o) {
		return priority - ((Order)o).priority;
	}	
}

import java.util.*;

/**
 * Created by erik on 11/02/16.
 */
public class Order extends MapObject {

	public int id;
	public int priority;
	Map<Product, Integer> products;

    public Order(int r, int c, int id) {
        super(r, c);
		this.id = id;
    }

    public int compareTo(Object o) {
		return products.size() - ((Order)o).products.size();
	}
}

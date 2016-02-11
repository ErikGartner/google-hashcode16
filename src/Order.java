import java.util.*;

/**
 * Created by erik on 11/02/16.
 */
public class Order extends MapObject {
	public int id;
	public int priority;
	Map<Product> products;

	public int compareTo(T o) {
		return priority - o.priority;
	}	
}

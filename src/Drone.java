import java.util.Map;

/**
 * Created by erik on 11/02/16.
 */
public class Drone extends MapObject{

    public int id;
    public int maxPayload;
    public Map<Product, Integer> inventory;
    public int availableAt;

    public Drone(int r, int c) {
        super(r, c);
    }

    public int compareTo(Object o) {
		return availableAt - ((Drone)o).availableAt;
	}
}

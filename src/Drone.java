import java.util.Map;

/**
 * Created by erik on 11/02/16.
 */
public class Drone extends MapObject{

    public int id;
    public int maxPayload;
    public Map<Product, Integer> inventory;


    public Drone(int r, int c) {
        super(r, c);
    }
}

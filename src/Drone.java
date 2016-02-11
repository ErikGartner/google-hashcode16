import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by erik on 11/02/16.
 */
public class Drone extends MapObject{

    public int id;
    public int maxPayload;
    public Map<Product, Integer> inventory;
    public int availableAt;

    public List<Command> commands = new ArrayList<Command>();

    public Drone(int r, int c, int id) {
        super(r, c);
        this.id = id;
    }

    public int compareTo(Object o) {
		return availableAt - ((Drone)o).availableAt;
	}

    public String getCommandString() {
        StringBuilder sb = new StringBuilder();
        for(Command c: commands) {
            sb.append(c.toString() + "\n");
        }
        return sb.toString();
    }
}

/**
 * Created by erik on 11/02/16.
 */
public class LoadCommand extends Command {

    public int time;
    public String commandString;

    public LoadCommand(Drone d, Order o, Product p, int count, Warehouse w) {
        commandString = d.id + " L " + o.id + " " + p.id + " " + count;
        time = d.distance(w) + 1;
    }

    public String toString() {
        return commandString;
    }

    public int getTime() {
        return time;
    }

}

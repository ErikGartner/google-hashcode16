/**
 * Created by erik on 11/02/16.
 */
public class DeliverCommand extends Command {

    public int time;
    public String commandString;

    public DeliverCommand(Drone d, Order o, Product p, int count, Order o) {
        commandString = d.id + " D " + o.id + " " + p.id + " " + count;
        time = d.distance(o) + 1;
    }

    public String toString() {
        return commandString;
    }

    public int getTime() {
        return time;
    }

}

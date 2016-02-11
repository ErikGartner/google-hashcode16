/**
 * Created by erik on 11/02/16.
 */
public class DeliverCommand extends Command {

    public Drone drone;
    public Order order;
    public Product product;
    public int count;

    public DeliverCommand(Drone d, Order o, Product p, int count) {
        this.drone = d;
        this.order = o;
        this.product = p;
        this.count = count;
    }

    public String toString() {
        return drone.id + " D " + order.id + " " + " " + product.id + " " + count;
    }

}

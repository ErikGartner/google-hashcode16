import java.util.List;

/**
 * Created by erik on 11/02/16.
 */
public class Solver2 {

    public Problem problem;

    public Solver2(Problem p) {
        this.problem = p;
    }

    public void solve() {
        for(Drone d: problem.droneList) {
            solve(d);
        }
    }

    public void solve(Drone d) {

        while(d.availableAt < problem.maxTurns) {
            Order o = bestOrderFor(d);
            List<Product> productList = chooseProductFrom(d, o);
            List<Warehouse> warehouses = chooseWarehouses(d, productList, o);
            deliver(warehouses, productList, o, d);
        }

    }

    private void deliver(List<Warehouse> warehouses, List<Product> productList, Order o, Drone d) {
    }

    private List<Warehouse> chooseWarehouses(Drone d, List<Product> productList, Order o) {
    }

    private List<Product> chooseProductFrom(Drone d, Order o) {

    }

    public Order bestOrderFor(Drone d) {
        return null;
    }


}

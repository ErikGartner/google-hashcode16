import java.util.*;

public class LinaSolver {
	public void preprocessOrders(List<Order> orders) {
		for (Order order : orders) {
			long sum = 0;

			for (Product p : order.products) {
				sum += order.distance(p.closestWarehouse());
			}

			order.priority = sum;
		}

		Collections.sort(orders);
	}

	public void solve(Problem p) {
		preprocessOrders(p.orderList);

		PriorityQueue<Drone> available = new PriorityQueue(p.droneList);

		while (p.currentTurn < p.maxTurns) {
			Drone d = queue.poll();
			p.currentTurn = d.availableAt;

			if (d == null) {
				System.out.println("Empty queue");
			}

			Order order = p.orderList.get(0);

			Product product = chooseProductToLoad(d, o);

			Warehouse w = chooseWarehouseToGetProduct(d, order, product);

			
		}

	}

	public Product chooseProductToLoad(Drone d, Order o) {
		return null;
	}	

	public Warehouse chooseWarehouseToGetProduct(Drone d, Order order, Product product) {
		return null;
	}
}
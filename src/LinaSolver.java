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

	public void solve() {

	}
}
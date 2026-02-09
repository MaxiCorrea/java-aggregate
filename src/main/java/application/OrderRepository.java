package application;

import java.util.Optional;

import domain.Order;
import domain.OrderId;

public interface OrderRepository {

	// AGREGATE ONLY!!
	Optional<Order> findById(OrderId id);

	void save(Order order);
	
}

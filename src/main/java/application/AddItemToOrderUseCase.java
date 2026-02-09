package application;

import domain.DomainException;
import domain.Money;
import domain.Order;
import domain.OrderId;
import domain.ProductId;

public class AddItemToOrderUseCase {

	private final OrderRepository orderRepository;
	
	public AddItemToOrderUseCase(
			final OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public void execute(
			final OrderId orderId,
			final ProductId productId,
			final int quantity,
			final Money price) {
		Order order = this.orderRepository.findById(orderId)
				.orElseThrow(()->{ throw new DomainException("Order not found");});
		order.addItem(productId, quantity, price);
		this.orderRepository.save(order);
	}
	
}

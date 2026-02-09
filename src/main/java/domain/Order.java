package domain;

import java.util.ArrayList;
import java.util.List;

// Aggregate Root!

public class Order {

	private final OrderId id;
	private OrderStatus status;
	private final List<OrderItem> items;
	private Money total;
	
	public Order(
			final OrderId id) {
		this.id = id;
		this.status = OrderStatus.CREATED;
		this.items = new ArrayList<>();
		this.total = Money.zero();
	}
	
	public void addItem(
			final ProductId id,
			final int quantity,
			final Money unitPrice) {
		OrderItem item = new OrderItem(id, quantity, unitPrice);
		this.items.add(item);
		recalculateTotal();
	}

	public void confirm() {
		validateModificable();
		if(items.isEmpty()) {
			String msg = "Not confirm a Order without items!";
			throw new DomainException(msg);
		}
		this.status = OrderStatus.CONFIRMED;
	}
	
	public void cancel() {
		if(status == OrderStatus.SHIPPED) {
			String msg = "Not cancel shipped order!";
			throw new DomainException(msg);
		}
		this.status = OrderStatus.CANCELLED;	
	}
	
	private void recalculateTotal() {
		this.total = Money.zero();
		for(OrderItem item : this.items)
			total = total.add(item.total());
	}
	
	private void validateModificable() {
		if(status != OrderStatus.CREATED) {
			String msg = "Unmodificable Order!";
			throw new DomainException(msg);
		}
	}
	
	public OrderId getId() {
		return id;
	}
	
	public Money getTotal() {
		return total;
	}
	
}

package domain;

public class OrderItem {

	private final ProductId id;
	private final int quantity;
	private final Money unitPrice;
	
	public OrderItem(
			final ProductId id, 
			final int quantity, 
			final Money unitPrice) {
		
		if(quantity < 0 ) {
			String msg = "negative quantity";
			throw new DomainException(msg);
		}
		this.id = id;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public ProductId getId() {
		return id;
	}
	
	public Money total() {
		return unitPrice.multiply(quantity);
	}

}

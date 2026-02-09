package domain;

import java.util.UUID;

public class OrderId {

	private final UUID id;
	
	public OrderId(
			final UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
	
}

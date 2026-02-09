package domain;

import java.util.UUID;

public class ProductId {

private final UUID id;
	
	public ProductId(
			final UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
	
}

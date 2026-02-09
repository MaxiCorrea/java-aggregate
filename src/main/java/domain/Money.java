package domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

	public static Money zero() {
		return new Money(BigDecimal.ZERO);
	}
	
	private final BigDecimal amount;
	
	public Money(
			final BigDecimal amount) {
		this.amount = amount;
	}
	
	public Money add(
			final Money other) {
		BigDecimal v = amount.add(other.amount);
		return new Money(v);
	}

	public Money multiply(
			final int quantity) {
		BigDecimal v = amount.multiply(BigDecimal.valueOf(quantity));
		return new Money(v);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return Objects.equals(amount, other.amount);
	}
	
}

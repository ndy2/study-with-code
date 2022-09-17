package lec04_operator;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public class Money_Java implements Comparable<Money_Java> {

	private final long value;

	public Money_Java(final long value) {
		this.value = value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final Money_Java moneyJava = (Money_Java)o;
		return value == moneyJava.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public int compareTo(@NotNull final Money_Java o) {
		return Long.compare(this.value, o.value);
	}
}

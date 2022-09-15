package com.study.ac.code;

public class StringPrinter implements Printer {

	private final StringBuffer buffer = new StringBuffer();

	@Override
	public void print(final String message) {
		buffer.append(message);
	}

	@Override
	public String toString() {
		return buffer.toString();
	}
}


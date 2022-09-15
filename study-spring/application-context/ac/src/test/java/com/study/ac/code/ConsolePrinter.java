package com.study.ac.code;

public class ConsolePrinter implements Printer {
	@Override
	public void print(final String message) {
		System.out.println(message);
	}
}


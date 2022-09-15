package com.study.ac.code;

import lombok.Setter;

@Setter
public class Hello {

	String name;
	Printer printer;

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		printer.print(sayHello());
	}
}

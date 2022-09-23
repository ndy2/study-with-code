package com.study.ac;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class MyTest {

	static class Calculator {

		int add(int a, int b) {
			return a + b;
		}
	}

	Random random = new Random();
	Calculator calculator = new Calculator();

	@RepeatedTest(100)
	void add() {
		int a = random.nextInt();
		int b = random.nextInt();
		int c = random.nextInt();

		assertThat(commutative(a, b)).isTrue();
		assertThat(associative(a, b, c)).isTrue();
		assertThat(identity(a)).isTrue();
	}

	/* 덧셈의 교환법칙: 덧셈의 순서를 바꾸어도 합은 변하지 않습니다 */
	boolean commutative(int a, int b) {
		return calculator.add(a, b) == calculator.add(b, a);
	}

	/* 덧셈의 결합법칙: 덧셈에서 묶는 순서를 바꾸어서 계산하여도 합은 변하지 않습니다 */
	private boolean associative(int a, int b, int c) {
		return calculator.add(calculator.add(a, b), c)
			== calculator.add(a, calculator.add(b, c));
	}

	/* 덧셈의 항등법칙: 0과 어떤 수의 합은 항상 자기 자신입니다 */
	private boolean identity(int a) {
		return calculator.add(a, 0) == a;
	}
}

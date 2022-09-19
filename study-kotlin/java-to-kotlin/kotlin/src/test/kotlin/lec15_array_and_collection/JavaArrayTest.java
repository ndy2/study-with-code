package lec15_array_and_collection;

import org.junit.jupiter.api.Test;

class JavaArrayTest {

	@Test
	void arrayTest() {

		int[] array = {100, 200};

		for (int i = 0; i < array.length; i++) {
			System.out.println("i : " + i + ", val : " + array[i]);
		}
	}
}

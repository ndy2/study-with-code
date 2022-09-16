package lec02_null;

class Null_Java {

	// unsafe - NPE 위험 있음
	boolean startsWithA(String s) {
		return s.startsWith("A");
	}

	boolean starsWithA1(String s) {
		if (s == null) {
			throw new IllegalArgumentException("null 이 들어 왔습니다.");
		}
		return s.startsWith("A");
	}

	Boolean starsWithA2(String s) {
		if (s == null) {
			return null;
		}
		return s.startsWith("A");
	}

	boolean starsWithA3(String s) {
		if (s == null) {
			return false;
		}
		return s.startsWith("A");
	}

	long addOneIfNotNull(Long number) {
		return number == null ? 0 : number + 1;
	}
}

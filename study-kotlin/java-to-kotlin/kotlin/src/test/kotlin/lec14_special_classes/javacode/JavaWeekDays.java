package lec14_special_classes.javacode;

public enum JavaWeekDays {

	MON(1),
	THE(2),
	WED(3),
	THU(4),
	FRI(5),
	SAT(6),
	SUN(7);

	private final int order;

	public int getOrder() {
		return order;
	}

	JavaWeekDays(final int order) {
		this.order = order;
	}
}

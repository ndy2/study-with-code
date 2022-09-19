package lec13_nestedclass.javacode;

public class JavaHouse {

	private final String address;
	private final LivingRoom livingRoom;

	public JavaHouse(final String address) {
		this.address = address;
		this.livingRoom = new LivingRoom(10);
	}

	public LivingRoom getLivingRoom() {
		return livingRoom;
	}

	public /*static*/ class LivingRoom {
		private final double area;

		public LivingRoom(final double area) {
			this.area = area;
		}

		/*public String getAddress(){
			return JavaHouse.this.address;*/
	}
}



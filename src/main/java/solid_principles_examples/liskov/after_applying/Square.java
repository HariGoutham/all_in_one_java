package solid_principles_examples.liskov.after_applying;

public class Square implements Shape {
	
	private int side;
	
	public Square(int side) {
		this.side = side;
	}
	
	public void setSide(int side) {
		this.side = side;
	}
	
	public int getSide() {
		return side;
	}

	@Override
	public int computeArea() {
		return side*side;
	}
}

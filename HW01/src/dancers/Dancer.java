package dancers;

public class Dancer implements IDancer{

	public Dancer leftChild;
	public Dancer rightChild;
	private int id;
	private boolean male;
	private int height;
	
	public Dancer(int id, boolean male, int height) {
		this.id = id;
		this.male = male;
		this.height = height;
	}

	@Override
	public int getID() {
		return id;
	}
	
	@Override
	public boolean isMale(){
		return male;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
}

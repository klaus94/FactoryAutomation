package stockManagement;

public class Product {
	private boolean ready;
	private final int id;
	
	public Product(int id) {
		this.id = id;
		ready = false;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public int getId() {
		return id;
	}
	
	
}

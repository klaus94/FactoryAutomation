package stockManagement;

public class Product {
	private boolean ready;
	private final int id;
	private String name;
	
	public Product(int id, String name) {
		this.id = id;
		ready = false;
		this.name = name;
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
	
	public String getName() {
		return name;
	}
	
}

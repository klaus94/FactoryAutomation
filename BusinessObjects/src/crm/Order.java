package crm;

public class Order {
	private final int id;
	private String title;
	
	public Order(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Order [title=" + title + "]";
	}
	
	
}

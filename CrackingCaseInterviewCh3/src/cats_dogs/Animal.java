package cats_dogs;

public abstract class Animal {
	private int order;
	protected String name;
	public Animal(String n) {
		name = n;
	}
	
	public void setOrder(int val) {
		order = val;
	}
	
	public int getOrder() {
		return order;
	}
	
	public boolean compareOrder(int val) {
		return order < val;
	}
	
	public boolean isOlder(Animal a) {
		return this.compareOrder(a.getOrder());
	}
	
}

package Bank;

public class Car implements Valuable{
	private String name;
	private double price;
	
	public Car(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	@Override public double estimateValue(int month) {
		return (price * 0.8 * Math.pow(0.99, month));
	}
	
	public String toString() {
		return String.format("Car name: %s", this.name);
	}
}

package Bank;

public class Human implements Valuable{
	private String name;
	private int age;
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override public double estimateValue(int age) {
		return Double.POSITIVE_INFINITY;
	}
	
	@Override public double estimateValue() {
		return Double.POSITIVE_INFINITY;
	}
	
	public String toString() {
		return String.format("Human name : %s", this.name);
	}
}

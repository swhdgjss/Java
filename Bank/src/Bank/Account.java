package Bank;

public class Account {
	public final String name;
	private double balance;
	
	public Account(String name, double money) {
		this.name = name;
		balance = money;
	}
	public double getBalance() {
		return balance;
	}
	
	public void credit(double money) {
		balance += money;
	}
	
	public void debit(double money) {
		balance -= money;
		if(balance <= 0) {
			System.out.println("Debit amount exceeded account balance");
			balance += money;
		} else {
			System.out.printf("subtracting %f from account balance", money);
		}
	}
}

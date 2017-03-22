package Bank;

public class Account {
	private double balance;
	
	public Account(double money) {
		balance = money;
	}
	public double getBalance() {
		return balance;
	}
	
	public void credit(double money) {
		balance += money;
	}
	
	public String debit(double money) {
		balance -= money;
		if(balance <= 0) {
			balance += money;
			return "Debit amount exceeded account balance";
		} else {
			return "subtracting %f from account balance";
		}
	}
	
	protected void setBalance(double money) {
		this.balance = money;
	}
}

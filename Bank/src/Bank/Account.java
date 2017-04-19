package Bank;

public abstract class Account {
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
	
	public void debit(double amount) throws Exception {
		balance -= amount;
	}
	
	protected void setBalance(double money) {
		this.balance = money;
	}
	
	public abstract double getWithdrawableAccount();
	
	public abstract void passTime(int time);
	
	public abstract void passTime();
}

package Bank;


import java.util.ArrayList;

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
	
	public static double sumForAccount(ArrayList<Account> list) {
		double sum = 0;
		for(Account account: list ) {
			sum += account.getBalance();
		}
		return sum;
	}
	
	public static void passTimeForLIst(ArrayList <Account> list, int month) {
		for(Account account: list) {
			account.passTime(month);
		}
	}
}
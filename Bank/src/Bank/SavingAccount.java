package Bank;

public class SavingAccount extends Account implements Valuable{
	private double interest;
	private int time = 0;
	
	public SavingAccount(double balance, double interest) {
		super(balance);
		this.interest = interest;
	}
	
	@Override
	public void debit(double amount) throws Exception {
		if(amount < 0) {
			throw new Exception();
		} else if(amount > this.getWithdrawableAccount()) {
			throw new Exception();
		}else {
			this.setBalance(this.getBalance() - amount);
		}
	}
	
	public double getWithdrawableAccount() {
		if(this.time < 12) {
			return 0;
		} else {
			return this.getBalance();
		}
	}

	public void passTime(int time) {
		this.time += time;
		if(this.time == 12) {
			this.setBalance(this.getBalance() * Math.pow(1 + interest, this.time));
		}		
	}
	
	@Override public double estimateValue(int month) {
		return this.getBalance() * Math.pow(1 + interest, month);
	}
	
	public String toString() {
		return String.format("SavingAccount_Balance: %s", this.getBalance());
	}
}

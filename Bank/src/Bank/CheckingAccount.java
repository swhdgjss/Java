package Bank;

public class CheckingAccount extends Account implements Valuable{
	private double creditLimit, interest, loanInterest;
	
	public CheckingAccount(double balance, double creditLimit, double interest, double loanInterest) {
		super(balance);
		this.creditLimit = creditLimit;
		this.interest = interest;
		this.loanInterest = loanInterest;
		this.setBalance(balance);
	}
	
	@Override
	public void debit(double amount) throws Exception {
		if(amount < 0) {
			throw new Exception("음수입력!");
		} else if(amount > this.getWithdrawableAccount()) {
			throw new Exception("Debit amount exceeded account balance.");
		}else {
			this.setBalance(this.getBalance() - amount);
		}
	}
	
	public void nextMonth() {
		if(this.getBalance() > 0) {
			this.setBalance(this.getBalance() * (1 +  interest));
		} else {
			this.setBalance(this.getBalance() * (1 + loanInterest));
		}
	}
	
	public double getWithdrawableAccount() {
		if(this.getBalance() + creditLimit < 0) {
			return 0;
		} else {
			return this.getBalance() + creditLimit;
		}
	}

	public void passTime(int time) {
		this.setBalance(this.getBalance() * Math.pow((1 + interest), time));
	}
	
	public boolean isBankrupted() {
		if(this.getWithdrawableAccount() <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override public double estimateValue(int month) {
		this.passTime(month);
		return this.getBalance();
	}
	
	public String toString() {
		return String.format("ChekingAccount_Balance: %s", this.getBalance());
	}
}
package Bank;

public class CheckingAccount extends Account{
	private double creditLimit, interest, loanInterest;
	
	public CheckingAccount(double balance, double creditLimit, double interest, double loanInterest) {
		super(balance);
		this.creditLimit = creditLimit;
		this.interest = interest;
		this.loanInterest = loanInterest;
		this.setBalance(balance);
	}
	
	@Override
	public String debit(double a) {
		if(this.getBalance() + creditLimit < a) {
				return "Debit amount exceeded account balance";
		} else {
			this.setBalance(this.getBalance() - a);
			return null;
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
}
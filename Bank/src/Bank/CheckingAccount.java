package Bank;

public class CheckingAccount extends Account{
	private double credit_limit, interest, loan_interest;
	
	public CheckingAccount(double balance, double credit_limit, double interest, double loan_interest) {
		super(balance);
		this.credit_limit = credit_limit;
		this.interest = interest;
		this.loan_interest = loan_interest;
		this.setBalance(balance);
	}
	
	@Override
	public String debit(double a) {
		if(this.getBalance() + credit_limit < a) {
				return "Debit amount exceeded account balance";
		} else {
			this.setBalance(this.getBalance() - a);
			return null;
		}
	}
	
	public void nextMonth() {
		if(this.getBalance() > 0) {
			this.setBalance(this.getBalance() + this.getBalance() * interest);
		} else {
			this.setBalance(this.getBalance() + this.getBalance() * loan_interest);
		}
	}
}

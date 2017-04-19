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
		} else if(amount > this.getWithdrawableAccount() && this.time < 12) {
			throw new Exception("아직 출금할 수 없습니다.");
		} else if(amount > this.getWithdrawableAccount()) {
			throw new Exception("Debit amount exceeded account balance.");
		} else {
			super.debit(amount);
		}
	}
	
	public double getWithdrawableAccount() {
		if(this.time < 12) {
			return 0;
		} else {
			return this.getBalance();
		}
	}

	@Override public void passTime(int time) {
		this.time += time;
		if(this.time == 12) {
			this.setBalance(this.getBalance() * Math.pow(1 + interest, this.time));
		}		
	}
	
	@Override public void passTime() {
		this.time ++;
		if(this.time == 12) {
			this.setBalance(this.getBalance() * Math.pow(1 + interest, this.time));
		}		
	}
	
	@Override public double estimateValue(int month) {
		return this.getBalance() * Math.pow(1 + interest, month);
	}
	
	@Override public double estimateValue() {
		return this.getBalance() * Math.pow(1 + interest, 1);
	}
	
	public String toString() {
		return String.format("SavingAccount_Balance: %s", this.getBalance());
	}
}

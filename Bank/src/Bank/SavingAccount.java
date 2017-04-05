package Bank;

public class SavingAccount extends Account implements Valuable{
	private double interest;
	private int time = 0;
	
	public SavingAccount(double balance, double interest) {
		super(balance);
		this.interest = interest;
	}
	
	public String debit(double money) {
		if(time < 12) {
			System.out.println("아직 출금할 수 없습니다.");
			return "아직 출금할 수 없습니다.";
		} else {
			this.setBalance(this.getBalance() - money);
			return null;
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

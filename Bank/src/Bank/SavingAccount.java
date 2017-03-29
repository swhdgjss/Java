package Bank;

public class SavingAccount extends Account{
	private double interest;
	private int time = 0;
	
	public SavingAccount(double balance, double interest) {
		super(balance);
		this.interest = interest;
	}
	
	public String debit(double money) {
		if(time < 12) {
			System.out.println("���� ����� �� �����ϴ�.");
			return "���� ����� �� �����ϴ�.";
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
}

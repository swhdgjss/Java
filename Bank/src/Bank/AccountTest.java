package Bank;

import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		CheckingAccount account1 = new CheckingAccount(100, 100, 0.1, 0.07);
		CheckingAccount account2 = new CheckingAccount(100, 100, 0.1, 0.07);
		
		System.out.printf("account1 balance: %f\n", account1.getBalance());
		System.out.printf("account2 balance: %f\n", account2.getBalance());
		
		System.out.print("Enter deposit amount for Account1: ");
		double money = s.nextDouble();
		account1.credit(money);
		
		System.out.printf("account1 balance: %f\n", account1.getBalance());
		System.out.printf("account2 balance: %f\n", account2.getBalance());
		
		System.out.print("Enter withdrawal amount for Account2:");
		money = s.nextDouble();
		String err = account2.debit(money);
		if(err != null) {
			System.out.println(err);
		}
		
		account1.nextMonth();
		account2.nextMonth();
		System.out.println("next month!");
		
		System.out.printf("account1 balance: %f\n", account1.getBalance());
		System.out.printf("account2 balance: %f\n", account2.getBalance());
		
	}
}
package Bank;

import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		double amount;
		
		Account account1 = new CheckingAccount(100, 50, 00.1, 0.07);
		Account account2 = new SavingAccount(100, 0.05);
		
		System.out.printf("account1 balance: $ %.2f\n \t현재출금가능액: %.2f\n", account1.getBalance(), account1.getWithdrawableAccount());
		System.out.print("Enter deposit amount for Account1: ");
		amount = s.nextDouble();
		account1.debit(amount);
		
		System.out.printf("account1 balance: $ %.2f\n \t현재출금가능액: %.2f\n", account1.getBalance(), account1.getWithdrawableAccount());
		boolean bankrupt = ((CheckingAccount) account1).isBankrupted();
		if(bankrupt == true) {
			System.out.println("account1 went Bankrupt!");
		}
		
		account1.passTime(1);
		System.out.printf("account1 balance: $ %.2f\n \t현재출금가능액: %.2f\n", account1.getBalance(), account1.getWithdrawableAccount());
		bankrupt = ((CheckingAccount) account1).isBankrupted();
		if(bankrupt == true) {
			System.out.println("account1 went Bankrupt!");
		}
		
		account1.passTime(5);
		System.out.printf("account1 balance: $ %.2f\n \t현재출금가능액: %.2f\n", account1.getBalance(), account1.getWithdrawableAccount());
		bankrupt = ((CheckingAccount) account1).isBankrupted();
		if(bankrupt == true) {
			System.out.println("account1 went Bankrupt!");
		}
		
		System.out.println();
		System.out.printf("account2 balance: $ %.2f\n \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
		System.out.println("6 months later!");
		account2.passTime(6);
		System.out.printf("account2 balance: $ %.2f\n \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
		account2.debit(50);
		
		System.out.println("next 6 months later!");
		account2.passTime(6);
		System.out.printf("account2 balance: $ %.2f\n \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
		
		System.out.println("next 1 months later!");
		account2.passTime(1);
		System.out.printf("account2 balance: $ %.2f\n \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
		account2.debit(50);
		System.out.printf("account2 balance: $ %.2f\n \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
	}
}
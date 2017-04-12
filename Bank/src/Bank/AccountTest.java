package Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		Account account1 = new CheckingAccount(100, 50, 0.01, 0.07);
		Account account2 = new SavingAccount(100, 0.05);
		
		try {
			System.out.println("Enter deposit amountn for Account1: ");
			double amount = s.nextDouble();
			account1.debit(amount);
			System.out.println("Account1 balance : $" + account1.getBalance());
			
			System.out.println("Enter deposit amountn for Account2: ");
			amount = s.nextDouble();
			account2.debit(amount);
			System.out.println("Account2 balance : $" + account2.getBalance());
		} catch(InputMismatchException e) {
			System.out.println("예외발생 : 숫자를 입력하세요\n" + e.toString());
		} catch(Exception e) {
			System.out.println("예외발생  : " + e.toString());
		} finally {
			account1.passTime(2);
			System.out.println("2 month later account1 : " + account1.getBalance());
		}
	}	
}
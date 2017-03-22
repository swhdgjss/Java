package Bank;

import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		Account account1 = new Account("account1", 50.00);
		Account account2 = new Account("account2", 00.00);
		
		System.out.printf("%s balance: $%f \n", account1.name, account1.getBalance());
		System.out.printf("%s balance: $%f \n", account2.name, account2.getBalance());
		
		System.out.print("Enter withdrawal amount for account1:");
		double tmp = s.nextDouble();
		account1.debit(tmp);
		
		System.out.printf("%s balance: $%f \n", account1.name, account1.getBalance());
		System.out.printf("%s balance: $%f \n", account2.name, account2.getBalance());
		
		System.out.print("Enter withdrawal amount for account2:");
		tmp = s.nextDouble();
		account2.debit(tmp);
	}

}

package Bank;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class AccountTest {
	public static void main(String args[]) throws Exception{
			CheckingAccount account1 = new CheckingAccount(100, 50, 0.01, 0.07);
			SavingAccount account2 = new SavingAccount(100, 0.05);
			
			ArrayList<Account> accountList = new ArrayList<Account>();
			accountList.add(account1);
			accountList.add(account2);
			
			System.out.println("전체 계좌의 잔액 합산 : " + Account.sumForAccount(accountList));
			
			System.out.println("전체 계좌의 12개월 후 적용");
			Account.passTimeForLIst(accountList, 12);
			System.out.println("전체 계좌의 잔액 합산 : " + Account.sumForAccount(accountList));
	}
}
package chap01;

import java.util.Scanner;

public class TEST2 {

	public static void main(String[] args) {
	
		boolean run = true;
		
		int balance = 10000;
		
		Scanner scanner=new Scanner(System.in);
		int inputInt =scanner.nextInt();
		
			int withdraw = 0;
			switch (inputInt) {
			case 1:
				System.out.println("예금액> " + balance);
				break;
			case 2:
				int inputWithdraw = withdraw + scanner.nextInt();
				System.out.println("출금액> " + inputWithdraw);
				break;
			case 3:
				int changedBalance = balance   ;
				System.out.println("잔고> " + changedBalance);
				break;
			case 4:
				System.out.println();
				run = false;
				break;
			default:
				break;
//			}

	}
	}
}

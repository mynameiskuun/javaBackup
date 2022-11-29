package chap01;

import java.util.Iterator;

import javax.swing.text.Document;

public class TEST {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			
		
		int num = (int) (Math.random()*6) +1;
		switch (num) {
		case 1:
			System.out.println("주사위는 1번입니다");
			break;
		case 2:
			System.out.println("주사위는 2번입니다");
			break;
		case 3:
			System.out.println("주사위는 3번입니다");
			break;
		case 4:
			System.out.println("주사위는 4번입니다");
			break;
		case 5:
			System.out.println("주사위는 5번입니다");
			break;
		default:
			System.out.println("주사위는 6번입니다");
			break;
		}
		}
}
}
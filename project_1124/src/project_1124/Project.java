	package project_1124;

import java.util.Scanner;


public class Project {
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int a = (int) (Math.random() * 9) + 1;
		int b = (int) (Math.random() * 9) + 1;
		int c = a * b;
		int scores = 0;
		
		for (int s = 0; s < 20; s++) {
			System.out.println("구구단을 외자");
			for (int q = 0; q < 20; q++) {
				System.out.println(a + " * " + b + " = ?");
				int userAnswer = scanner.nextInt();
				if (userAnswer == c) {
					System.out.println("정답입니다");
					scores += 5;
				} else {
					System.out.println("틀렸습니다");
					System.out.println(a + " * " + b + " = ?");
				}
			}
		}
	}
}


package project_1123;

import java.util.Scanner;

public class Project {

	private static int s;

	public static void main(String[] args) {

		boolean run = true;
		int studentNum = 0;
		String[] Restaurant = new String[99];
		int[] Scores = new int[99];
		int[] Review = new int[99];
		int sum = 0;
		int avg = 0;
		

		Scanner scanner = new Scanner(System.in);

		int a = (int) (Math.random() * 9)+ 1;
		int b = (int) (Math.random() * 9)+ 1;
		int c = a*b;
	
		
//		for(int s = 0; s<20; s++) {
//			System.out.println("구구단을 외자");
//			System.out.println(a + " * " + b + " = ?");
//			int userAnswer = scanner.nextInt();
//			if(userAnswer == c) {
//				System.out.println("정답입니다");
//			} else {
//				System.out.println("틀렸습니다");
//				System.out.println(a + " * " + b + " = ?");
//			}
//		}
		
		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.설문 참여 | 2.점수입력 | 3.리뷰입력 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				System.out.println("식당이름 입력하세요 ");
				String element = scanner.nextLine();
				Restaurant[0] = element;
				

			} else if (selectNo == 2) {
				
				for (int i = 0; i < studentNum; i++) {
				// 점수 입력
				//
					
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < studentNum; i++) {
					System.out.println("Scores[" + i + "]:" + Scores[i]);
				}
			} else if (selectNo == 4) {

				sum = 0;
				for (int j = 0; j < studentNum; j++) {
					sum += Scores[j];
				}
				avg = sum / studentNum;
				int max = Scores[0];
				
				for (int k = 0; k < studentNum; k++) {
					if (max < Scores[k]) {
						max = Scores[k];
					}
				}
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + avg);
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}

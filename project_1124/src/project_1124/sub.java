package project_1124;

import java.util.Scanner;

public class sub {

	public static void main(String[] args) {
	
		Scanner s1 = new Scanner(System.in);
		
		boolean run = true;
		
		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");

			int selectNo = s1.nextInt();
			int studentNum = 0;
			int scores[] = null;
			int sum = 0;
			int avg = 0;
			
			if (selectNo == 1) {

				System.out.print("학생수> ");
				studentNum = s1.nextInt();
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < studentNum; i++) {
					scores[i] = s1.nextInt();
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < studentNum; i++) {
					System.out.println("scores[" + i + "]:" + scores[i]);
				}
			} else if (selectNo == 4) {

				sum = 0;
				for (int j = 0; j < studentNum; j++) {
					sum += scores[j];
				}
				avg = sum / studentNum;
				int max = scores[0];

				for (int k = 0; k < studentNum; k++) {
					if (max < scores[k]) {
						max = scores[k];
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



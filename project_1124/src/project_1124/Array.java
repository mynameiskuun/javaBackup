package project_1124;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
	
		Scanner s1 = new Scanner(System.in);
		
		int scores[][];
		int studentNum = 0;
		int lectureNum = 0;
		int indexNum = 0;
		boolean run = true;
		
		
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1. 학생 수 입력 | 2. 과목 수 입력 | 3. 값 확인 | 4. 종료");
			System.out.println("----------------------------------------------");
			
			indexNum = s1.nextInt();
			
			if(indexNum == 1) {
				System.out.println("학생 수를 입력하세요>");
				studentNum = s1.nextInt();
			} else if(indexNum == 2) {
				System.out.println("과목 수를 입력하세요>");
				lectureNum = s1.nextInt();
			} else if(indexNum == 3) {
				while(true) {
				
				}
				// 값 출력
			} else if(indexNum == 4) {
				run = false;
			}
	
			}
		System.out.println("프로그램 종료");
		}
		
	}



package project_1125;

import java.util.Scanner;

public class ArrayEx {

	public static void main(String[] args) {
		
		Scanner s1 = new Scanner(System.in);
		int scores[][] = null;
		int num;
		int num2;
		boolean run = true;
		
		
			System.out.println("학생 수를 입력하세요");
			num = s1.nextInt();
			//학생입력
			System.out.println("과목 수를 입력하세요");
			//과목입력
			num2 = s1.nextInt();
			
			scores = new int[num][num2];
			
			for(int i=0; i<num; i++) {
				for(int j=0; j<num2; j++) {
					System.out.println(i + "과목 " + j + "번째 학생 점수>");
					scores[i][j] = s1.nextInt();
				}
			}
			// 2차원 배열
			for(int i=0; i<num; i++) {
				for(int j=0; j<num2; j++) {
					System.out.print(scores[i][j]+ "\t");
				}
				System.out.println();
			}
	
		}
		

		
	}


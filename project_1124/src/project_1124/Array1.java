package project_1124;
// 2차원 배열
import java.util.Scanner;
public class Array1 {
		
	public static void main(String[] args) {
		
		Scanner s1 = new Scanner(System.in);
		
		int inputNum = 0;
		int inputNum2 = 0;
		int scores[][] = null;
		
		System.out.println("학생 수를 입력하세요");
		inputNum = s1.nextInt();
		System.out.println("과목 수를 입력하세요");
		inputNum2 = s1.nextInt();
		
		scores = new int[inputNum][inputNum2];
		
		for(int i=0; i<inputNum; i++) {
			for(int j=0; j<inputNum2; j++) {
				System.out.println(i +"번 과목 " + j + "번째 점수 입력>");
				scores[i][j] = s1.nextInt();
			}	
		}
		for(int i=0; i< inputNum; i++) {
			for(int j=0; j<inputNum2; j++) {
				System.out.print(scores[i][j]+"\t");
				
			}	
			System.out.println();
		}
		

	}

}

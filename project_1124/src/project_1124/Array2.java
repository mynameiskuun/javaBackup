package project_1124;

import java.util.Scanner;

public class Array2 {

	public static void main(String[] args) {
		// 식당이름 1번식당 2번식당 3번식당
		// A : 5점 3점 2점
		// B : 4점 2점 1번 점수

		// 식당이름 1번식당 2번식당 3번식당
		// A : 아주좋습니다 별로입니다 보통입니다
		// B : 별로입니다 보통입니다 아주 좋습니다

		// 보기 모드

		Scanner s1 = new Scanner(System.in);

		int scores[] = new int[3];
		String review[] = new String[3];
		boolean run = true;
		String reviewNum = null;
		String userID = "";

		while (run) {

			System.out.println("--------------------------------");
			System.out.println("1. 입력   2. 출력   3. 응용   4. 종료");
			System.out.println("--------------------------------");
			System.out.print(">");
			
			int indexNum = s1.nextInt();
			
			if (true) {
				
				System.out.println("사용자 아이디를 입력해주세요.");
				System.out.println("      A?   or   B?      ");
				System.out.println(">");
				userID += s1.next();
				
				
				if (userID == "A") {
					System.out.println("A님 환영합니다.");
					System.out.println();
				}
			} else if (indexNum == 2) {
				System.out.println("자유롭게 평가해 주세요.");
			} else if (indexNum == 3) {
				
			} else if (indexNum == 4) {
				run = false;
			}
		}
		System.out.println("프로그램을 종료합니다.");

	}

}

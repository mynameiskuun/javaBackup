package project_1125;

import java.util.Scanner;

public class Stu1 {
		
	public static void main(String[] args) {
		Student[] stu = new Student[3];
		Scanner s1 = new Scanner(System.in);
		boolean answer = true;
		
		stu[0] = new Student("홍길동", "202201", "서울 마포구");
		stu[1] = new Student("김길동", "202202", "서울 마포구");
		stu[2] = new Student("박길동", "202203", "서울 마포구");
		
		
		for(int i=0; i<stu.length; i++) {
			System.out.println(stu[i].name+"의 국어점수 입력>");
			stu[i].kor = s1.nextInt();
			System.out.println(stu[i].name+"의 수학점수 입력>");
			stu[i].math = s1.nextInt();
			System.out.println(stu[i].name+"의 영어점수 입력>");
			stu[i].eng = s1.nextInt();
			
			
		}
		System.out.println("\t국어\t수학\t영어");
		
		
		for(int i =0; i<stu.length; i++) {
			System.out.println(stu[i].name+"\t"+stu[i].kor+"\t"+stu[i].math+"\t"+stu[i].eng);
		}
//		for(int j=0; j<stu.length; j++) {
//			System.out.println(stu[j].name+"의 영어점수를 수정하시겠습니까?");
//			stu[j].eng = s1.nextInt();
//		}
		
		System.out.println("점수를 수정할 학생 학번 입력");
		String hakbun = s1.next();
		for (int i = 0; i<stu.length; i++) {
			if(hakbun.equals(stu[i].hakbun)) {
				System.out.println("수정할 과목 입력>");
				String subj = s1.next();
				if (subj.equals("국어")) {
					System.out.println("국어 과목 점수 입력>");
					int num = s1.nextInt();
					stu[i].kor = num;
				}
			}
		}
		System.out.println("\t국어\t수학\t영어");
		for(int i =0; i<stu.length; i++) {
			System.out.println(stu[i].name+"\t"+stu[i].kor+"\t"+stu[i].math+"\t"+stu[i].eng);
			
		}
	}
	
}

package project_1128;

import java.util.Scanner;

public class asd {
	
	public static void main(String[] args) {
		
		sumMethod1 s1 = new sumMethod1();
		Scanner scan = new Scanner(System.in);
		s1.exportMethod();
		// exportMethod() 메소드 내부의 sysout 이 실행됨.
		System.out.println(s1.exportMethod());
		// exportMethod() 의 return값인 0을 sysout을 통해 출력함.
		System.out.println(s1.sumMethod());
		// return값이 있는 sumMethod()의 sum 값을 sysout을 통해 출력.
		System.out.println(s1.nSumMethod(10)); 
		// 매개변수 10이 들어간 1~n까지의 합 메소드 출력됨.
	
		System.out.print("N : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.println(s1.divMethod(num1,num2));
		
		
		// 매개변수 10,5 두개가 들어간 두 정수의 나눗셈 메소드 divMethod의 return값 result가 출력됨.
		System.out.println(s1.changeMethod("MAkuNouchi"));
		// 문자열의 소문자를 대문자로 바꿔주는 메소드
		
		
		
		// sysout은 확실한 return값이 있을때 콘솔창에 찍을 수 있음.
	}
}
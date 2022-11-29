package project_1129;

public class RefEx {

	public static void main(String[] args) {
		int x= 10, y = 20;
		String str = "연습";
		String str1 = "연습";
		System.out.println(x == y);
		System.out.println(str == str1);
		// equals() 를 쓰는 이유, 메모리를 비교한다
		
//		int[] intArray = null;
//		intArray[0] = 10;
		// intArray의 값이 null인데 값을 입력하려고 해서 nullpointerror 발생
		
		String strVar1 = "신민철";
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2) {
			System.out.println("strVar1과 strVar2는 참조가 같음"); 
		} else {
			System.out.println("strVar1과 strVar2는 참조가 다름");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("strVar1과 strVar2는 문자열이 같음");
		}
		
		String strVar3 = new String("신민철");
		String strVar4 = new String("신민철");
		
		if(strVar3 == strVar4) {
			System.out.println("strVar3과 strVar4는 참조가 같음");
		}else {
			System.out.println("strVar3과 strVar4는 참조가 다름");
		}
		
		if(strVar3.equals(strVar4)) {
			System.out.println("strVar3과 strVar4는 문자열이 같음");
		}
	}
	
}

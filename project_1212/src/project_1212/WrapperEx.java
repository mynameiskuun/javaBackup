package project_1212;

public class WrapperEx {

	public static void main(String[] args) {

		int x = 10;
		Integer y = new Integer(x);
		Integer y1 = x;
		System.out.println(x == y1);
		int z = Integer.parseInt("123");
		System.out.println(z);
		int z1 = Integer.valueOf("123");
		System.out.println(z1);
		
	// Wrapper 사용 이유
	// 참조형 변수 화 시켜서 다양한 메소드를 사용하기 위함.
	// int 
	}
}

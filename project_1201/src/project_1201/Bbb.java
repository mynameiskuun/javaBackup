package project_1201;

public class Bbb {
	static final double PI = 3.141592;
	final String b = "Test";
	void bbb() {
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		System.out.println(Bbb.PI);
		Bbb b1 = new Bbb();
		b1.bbb();
//		b1.b = "asd";
		// b는 final 속성이 붙어있기 때문에
		// 수정이 불가능함
	}
}

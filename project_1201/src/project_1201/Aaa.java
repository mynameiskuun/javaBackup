package project_1201;

public class Aaa {

	static int a;
	int b;
	// 메모리에 생성이 되지 않았기 때문에 사용 불가능.
	// 인스턴스를 생성했을때 heap 영역에 메모리가 생기기 때문에
	// 이 변수는 새로운 객체를 생성 한 뒤에 사용 가능함.
	
	static void aaa() {
//		System.out.println(b);
		// 위의 이유로 b에 접근 불가능
	}
	
	void bbb() {
		System.out.println(a);
		System.out.println(this.b);
	}
	
	void ccc() {
		b = 20;
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		Aaa.a = 20;
		Aaa.aaa();
		//Aaa클래스는 static속성이 없기때문에, 해당 변수 및 메소드에 직접 접근 불가능.
		
		
		Aaa a1 = new Aaa();
		Aaa a2 = new Aaa();
		// 클래스 Aaa의 필드가 static으로 설정 된 경우,
		// 위의 두줄의 코드는 필요 없는 코드가 되어버림
		
		
		a2.a = 19;
		System.out.println(a1.a);
		// Aaa클래스에 static 속성이 빠져있기 때문에,객체 생성 없이 해당 변수에 직접 접근 불가능.
		
//		Aaa.aaa();
//		Aaa.bbb();
//		Aaa.ccc();
		// Aaa.bbb,Aaa.ccc가 안되는 이유
		// Static 설정이 되어있지 않기 때문에,
		// 해당 메소드는 객체 생성 이후에 사용 가능.
	}
}

package project_1201;

public class ClassName {

	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	static {
//		field1 = 10;
//		method1();
		field2 = 10;
		method2();
	}
	
	static void method3() {
//		this.field1 = 10;
//		this.method1();
		field2 = 10;
		method2();
	}
	
	static void Method3() {
		ClassName obj = new ClassName();
		// 이와 같이 객체를 생성하면 아래의 static 필드에 접근 가능
		obj.field1 = 10;
		obj.method1();
	}
	
}

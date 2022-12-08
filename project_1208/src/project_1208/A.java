package project_1208;

public class A {

	B field1 = new B();
	C field2 = new C();
	
	
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	
	// 정적 필드 초기화
//	static B field3 = new B();
	static C field4 = new C();
	
	// 정적 메소드
	static void method2() {
//		B var3 = new B();
		C var4 = new C();
	}
	
	class B {
	}
	
	static class C {
	}
}

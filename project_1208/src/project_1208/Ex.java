package project_1208;

public class Ex {
	Ex() {
		System.out.println("A 객체 생성");
	}
	
	class B {
		B() {}
//		static int field1;
		int field2;
		void method1() {}
		void method2() {}
	}
	
	static class C {
		C() { System.out.println("C 객체가 생성됨"); }
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	void method() {
		// 로컬클래스
		class D {
			D() { System.out.println("D 객체가 생성됨"); };
			int field1;
//			static int field2;
			void method1() {}
//			static void method() {}
		}
		
		D d = new D();
		d.field1 = 3;
		d.method1();
		// D 객체는 이 코드를 작성한 시점에 생성되는것이 아니라
		// Ex.method() 메소드를 호출한 시점에 생성됨.
		
	}

}

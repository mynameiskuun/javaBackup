package project_1201;

public class B {

	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
//		a.field3 = 1;
		// private이라서 접근 불가능
		a.method1();
		a.method2();
//		a.method3();
		// private이라서 접근 불가능
	}
}

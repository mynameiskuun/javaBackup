package package2;

import package1.A;

//public class B {
//	public void method() {
//		A a = new A();
//		a.field = "value";
//		a.method();
//	}
//}

public class B extends A{
	
	public B() {
		super();
		this.field = "value";
		this.method(); 
	}
	
//	protected void method() {
//		A a = new A();
//		a.field = "value";
//		a.method();
//	}
	
	public static void main(String[] args) {
		
		B b1 = new B();
		
		System.out.println(b1.field);
		b1.method();
	}
}

package DefaultMethodEx;

public class MyClassB implements MyInterface{

	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
		MyInterface.super.method2();
	}

	
}

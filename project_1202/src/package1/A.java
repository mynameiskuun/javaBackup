package package1;

public class A {
	protected String field;
	protected A() {}
	
	protected void method() {
	// 같은 클래스 내에서는 접근 가능
	// 같은 클래스의 B 에서 protected 필드에 접근 가능
	}
}

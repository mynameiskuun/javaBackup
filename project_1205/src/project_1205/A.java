package project_1205;


class B extends C{
	
}
class C{
	
}

public class A {
	public static void main(String[] args) {
		C c = new B();
		// 상속관계가 아닌 독립적인 관계일때 이렇게는 사용하지 못함.
		// (class B extends C 가 아닌 class B 일때)
		B b = (B) new C();
		// 부모 자식간의 캐스팅
	}
}

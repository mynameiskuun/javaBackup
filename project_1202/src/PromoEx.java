
class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends C {}

public class PromoEx {

	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = new B();
//		A a2 = new c;
//		A a3 = new d;
//		A a4 = new e;
//		B b1 = new D;
		C c1 = new E();
	}
}

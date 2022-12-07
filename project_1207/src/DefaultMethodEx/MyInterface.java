package DefaultMethodEx;

public interface MyInterface {

	public void method1();
	default void method2() {
		System.out.println("method2() 추가");
	};
	// 시간이 흘러 인터페이스의 구현 클래스에 메소드를 추가하고 싶을때
	// 혹은 이미 존재하는 메소드가 하위 클래스에서 재정의가 필요할때
	// 인터페이스에 default 메소드를 만들어서 하위 클래스에서 필요에 따라 재정의 혹은 추가해서 사용.
}

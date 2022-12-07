package DefaultMethodEx;

public interface ParentInterface {
	public void method1();
	default void method2() {/* 재정의 */}
	
	// 부모의 method 타입이 default일 경우, 구현 클래스에서 재정의를 강요하지 않음.
	// 재정의 해도되고 안해도됨.
}

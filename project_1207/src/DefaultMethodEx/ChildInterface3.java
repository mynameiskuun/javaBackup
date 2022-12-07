package DefaultMethodEx;

public interface ChildInterface3 extends ParentInterface{
	
	 public void method2();
	 // 하위 인터페이스에서 default 메소드를 추상 메소드로 재선언.
	 // 이 경우, 구현 클래스에서 method2의 호출이 강제됨.
	 void method3();

}

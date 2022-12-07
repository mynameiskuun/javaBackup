
public class MyclassEx {

	public static void main(String[] args) {
//		RemoteControl rc = new SmartTelevision();
//		MyClass mc = new MyClass(rc);
//		mc.methodA();
//		mc.methodB(rc);
		
		// 인터페이스 RemoteControl이 선언만 되고 객체 생성이 되지 않으면
		// mc.methodB(rc); 에서 nullpointer에러가 남.
		// 지금처럼 5행에 new SmartTelevision() 선언을 해줘야 생성 및 재사용이 가능.
		
		// rc에 new Television을 넣어도 실행이 됨.
		
		MyClass mc = new MyClass(new Television());
		mc.methodA();
		mc.methodB(new Television());
		
		// 인터페이스의 사용은 곧 추상메소드의 사용이다.
	}
}

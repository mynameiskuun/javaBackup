
public class bbb extends aaa{

	
	void aaa() {
		System.out.println("com1");
		super.aaa();
		// super.aaa()을 작성 해주는 이유
		// 오버라이딩 된(재정의된) 메소드 aaa() 뿐만 아니라
		// 부모의 원 메소드 aaa() 또한 호출하고 싶을 때 super.aaa()를 작성해줌
		// main 메소드에서 aaa() 호출시 원 메소드 및 오버라이딩 된 메소드 모두 호출됨
	}
}

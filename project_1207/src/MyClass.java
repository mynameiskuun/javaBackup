
public class MyClass {

	//필드
	RemoteControl rc = new Television();
	
	//생성자
	MyClass(RemoteControl rc) {
		this.rc = rc;
	}
	
	//메소드
	void methodA() {
		//로컬변수
		RemoteControl rc = new Audio();
		System.out.println("qwe");
	}
	
	void methodB(RemoteControl rc) {
		rc.turnOn();
	}
}

package InterfaceEx;

public class asd {

	public static void main(String[] args) {

		RemoteControl rs;
//		rs = new Television();
		rs = new Audio();
		
		rs.turnOff();
		// 인터페이스는 생성자가 없다.
		// 
		rs.setVolume(6);
		rs.setMute(false);
	}

}


public class tvMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartTelevision st = new SmartTelevision();
		st.turnOn();
		st.search("https://naver.com");
		st.setVolume(8);
		st.turnOff();
	}

}

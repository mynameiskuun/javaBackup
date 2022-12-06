package InterfaceEx;

class Test2 extends Television {

	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
}

public class TextEx {
	public static void main(String[] args) {
		RemoteControl rc2 = new RemoteControl() {
			

			private int volume;

			@Override 
			public void turnOn() {
				System.out.println("TV를 켭니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("TV를 끕니다.");
			}

			@Override
			public void setVolume(int volume) {
				if(volume>RemoteControl.MAX_VOLUME) {
					this.volume = RemoteControl.MAX_VOLUME;
				} else if (volume<RemoteControl.MIN_VOLUME) {
					this.volume = RemoteControl.MIN_VOLUME;
				} else {
					this.volume = volume;
				}
				System.out.println("현재 TV 볼륨: " + this.volume);
			}
			
		};
		
		Test2 t1 = new Test2();

		t1.turnOn();
	}
}

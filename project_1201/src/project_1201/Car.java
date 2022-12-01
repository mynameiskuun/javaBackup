package project_1201;

public class Car {

	String model;
	int speed;
	
	Car(String model) {
		this.model = model;
	}
	
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void run() {
		for(int i=0; i<=200; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.시속:"+this.speed+"km/h");
		}
	}

}

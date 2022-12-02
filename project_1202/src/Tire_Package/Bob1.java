package Tire_Package;

public class Bob1 {

	//필드
	Tire breakfast = new Tire("아침식사", 6);
	Tire lunch = new Tire("점심식사", 12);
	Tire dinner = new Tire("저녁식사", 18);
	//생성자
	
	//식사시간
	// String breakfast
	// String lunch
	// String dinner
	
	//메소드
	int run() {
		System.out.println("[허기가 집니다]");
		if(breakfast.roll()==false) { stop(); return 1;};
		if(lunch.roll()==false) { stop(); return 2;};
		if(dinner.roll()==false) { stop(); return 3;};
		return 0;
	}
	
	//시간이 흐릅니다
	//
	
	void stop() {
		System.out.println("[움직임을 멈춥니다.]");
	}
}


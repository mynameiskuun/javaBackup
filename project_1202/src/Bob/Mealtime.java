package Bob;

public class Mealtime {
	Bob breakfast = new Bob("아침", 1);
	Bob lunch = new Bob("점심", 1);
	Bob dinner = new Bob("저녁", 1);
	
	void stop() {
		System.out.println("[배가 고픕니다.]");
	}
	int run(int time) {
		System.out.println("["+(time+1)+"시 열심히 일합니다.]");
		if (time > 6 && time < 12 && breakfast.roll() == false) {
			stop();
			return 1;
		}
		if (time > 13 && time < 19 && lunch.roll() == false) {
			stop();
			return 2;
		}
		if (time > 19 && time < 23 && dinner.roll() == false) {
			stop();
			return 3;
		}
		return 0;
	}
}
package Bob;

public class Bob {
	int max;
	int acc;
	String time;
	
	public Bob(String time, int max) {
		this.time = time;
		this.max = max;
	}
	
	public boolean roll() {
		++acc;
		if (acc < max) {
			System.out.println("밥먹고 버티기 "+ (max-acc)+ "시간");
			return true;
		} else {
			System.out.println("***" + time + " 배가 고픕니다 ***");
			return false;
		}
	}
	
}
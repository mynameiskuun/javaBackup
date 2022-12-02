package Bob;

public class Kimbob extends Bob{

	public Kimbob(String time, int max) {
		super(time, max);
	}

	public boolean roll() {
		++acc;
		if (acc < max) {
			System.out.println("김밥먹고 버티기 "+ (max-acc)+ "시간");
			return true;
		} else {
			System.out.println("***" + time + " 김밥먹고 배고파서 쓰러짐 ***");
			return false;
		}
	}

}
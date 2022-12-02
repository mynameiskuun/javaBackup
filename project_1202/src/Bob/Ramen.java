package Bob;

public class Ramen extends Bob{

	public Ramen(String time, int max) {
		super(time, max);
	}

	public boolean roll() {
		++acc;
		if (acc < max) {
			System.out.println("라면먹고 버티기 "+ (max-acc)+ "시간");
			return true;
		} else {
			System.out.println("***" + time + " 라면먹고 배고파서 쓰러짐 ***");
			return false;
		}
	}

}
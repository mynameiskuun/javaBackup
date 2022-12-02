package Tire_Package;

public class dinner extends Tire {

	// 필드
	// 생성자
	public dinner(String location, int maxRotation) {
		super(location, maxRotation);
	}

	// 메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + " 다음 저녁 먹을 시간 " + (maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + "먹을 시간 ***");
			return false;
		}
	}

}

// 밥 상속해서 class ramen
// 메소드 roll 재정의
package Tire_Package;


public class Bob {

	//필드
	public int maxRotation; // 안먹고 버티는 시간
	public int accumulatedRotation; // 누적시간
	public String location; // 밥장소
	
	//생성자
	public Bob(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	//메소드
	public boolean roll() {
		++accumulatedRotation; //누적 회전수 1증가
		if(accumulatedRotation<maxRotation) {
			System.out.println(location + "밥 안먹고 버틸 수 있는 시간: " + (maxRotation-accumulatedRotation) + "시간");
			return true;
		} else {
			System.out.println("*** " + location + " 먹을 시간 ***");
			return false;
		}
	}
}

// 필드 안먹고 버티는 시간(max
//누적시간 cc
//밥장소 location

//클래스 식사시간(mealtime)


//누적시간 증가
//max acc

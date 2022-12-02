package Tire_Package;

public class Tire {

	//필드
	public int maxRotation;
	public int accumulatedRotation;
	public String location;
	
	//생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	//메소드
	public boolean roll() {
		++accumulatedRotation; //누적 회전수 1증가
		if(accumulatedRotation<maxRotation) {
			System.out.println(location + "Tire 수명: " + (maxRotation-accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		}
	}
}

//클래스 밥
// 필드 안먹고 버티는 시간(max
//누적시간 cc
//밥장소 location

//클래스 식사시간(mealtime)


//누적시간 증가
//max acc

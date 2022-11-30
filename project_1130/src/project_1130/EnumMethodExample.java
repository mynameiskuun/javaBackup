package project_1130;

public class EnumMethodExample {

	public static void main(String[] args) {
		//name() 메소드
		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println(name);
		
		//ordinal() 메소드
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		
		//compareTo() 메소드
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);
		
		//valueOf() 메소드
		if(args.length == 1) {
			String strDay = args[0];
			Week weekDay = Week.valueOf(strDay);
			if(weekDay == Week.SATURDAY || weekDay == Week.SUNDAY) {
				System.out.println("주말 이군요");
			} else {
				System.out.println("평일 이군요");
			}
		}
		
	
		//values() 메소드
		Week[] days = Week.values();
		for(Week day : days) {
			System.out.println(day);
		
			// Week strDay = Week.valueOf("FRIDAY");
			// System.our.println(strday)
			// "FRIDAY"를 valueOf 메소드에 넣고, enum타입의 변수에 넣어서 자동적으로 enum 타입 변수로 변환.
			// 이렇게 하면, 나중에 FRIDAY라는 값을 키워드로서 비교할 수 있음.
			// ex) if(strDay == Week.valueOf("FRIDAY"){
			// System.out.println("오늘은 휴일 입니다");
			
		}
	}

}

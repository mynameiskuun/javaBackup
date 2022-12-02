package Bob;

public class BobEx {

	public static void main(String[] args) {
		Mealtime mt = new Mealtime();
		for (int i=6; i<20; i++) {
			int hungry = mt.run(i);
			switch(hungry) {
			case 1:
				mt.breakfast = new Ramen("아침", 2);
				break;
			case 2:
				mt.lunch = new Kimbob("점심", 3);
				break;
			case 3:
				mt.dinner = new Ramen("저녁", 2);
				break;
			}
			System.out.println("------------------");
		}
		
	}

}
package project_1125;

public class StudentMain {

	public static void main(String[] args) {
	
		Student kim = new Student("김익명","07학번","서울");
		Student nam = new Student("s","a", "a",90,70,80);
//		Student cal = new sum();
//		Student avg = new avg();
		System.out.println(nam.address);
		
		System.out.println(nam.sum());
		System.out.println(nam.avg());
		nam.printSum();
		nam.printAvg();
	}

}

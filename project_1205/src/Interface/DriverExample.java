package Interface;

import java.util.Scanner;

public class DriverExample {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Driver driver = new Driver();
		
		

		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		driver.drive(bus);
		driver.drive(taxi);

		System.out.println("택시와 버스 중 하나를 선택> ");
		String inS = scan.next();
			if (inS.equals("택시")) {
				driver.drive(taxi);
				
				// vehicle = new Taxi();
				// driver.driver(vehicle);
				// 두 코드 같은 의미
			} else if (inS.equals("버스")) {
				driver.drive(bus);
				// vehicle = new Bus();
				// driver.driver(vehicle);
			}
			
			//다형성 = 하나를 설계 해 두고, 여러가지로 사용할 수 있게 하는게 핵심
	}

}

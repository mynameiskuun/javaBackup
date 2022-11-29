package project_1124;

public class Calculator {

	void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	int plus(int x, int y) {
		int result = x + y;
		return result;
	}

	double divide(int x, int y) {
		double result = (double) x / (double) y;
		return result;
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.powerOn();
		int asd = c1.plus(3,10);
		// 처음에 sysout c1.plus(3,10)만 입력해서 unreachable code 오류 발생
		// 왜냐하면, 위의 클래스 부분에 return이 있는데, 컴파일러는 return을 만나면
		// 해당 부분에서 로직을 종료시킴. 따라서 이후의 sysout c1.plus(3,10)은
		// 실행이 되지 않기 때문에 unreachable code 오류가 발생
		System.out.println(asd);
		double sdf = c1.divide(20,40);
		System.out.println(sdf);
		c1.powerOff();
	}
}

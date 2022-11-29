package project_1124;

class test{
	
	private int asd = 3;
	
	void setNum(int number) {
		asd = number;
	}
	// test의 클래스 내부의 asd변수는 private 설정으로 인해
	// main 메소드에서 변수 값의 변경이 불가능함.
	// 이를 해결하기 위해 test 클래스 내부에 asd변수를 변경할 수 있는 메소드를 설정 후
	// 설정한 메소드를 이용해 main 메소드 안에서 asd 변수의 값을 변경함
	
	void printStr() {
		System.out.println(asd);
	}
}
public class prac003 {

	public static void main(String[] args) {
		new test();
		test s1 = new test();
		s1.setNum(2320);
		s1.printStr();
	
		
		
	}
}

// 접근제한자 public, private 등 총 4개
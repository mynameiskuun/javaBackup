package project_1208;

public class Outter {

	
	//자바 7 이전
	public void method1(final int arg) {
		final int localVariable = 1;
//		arg = 100;
//		localVariable = 100;
		class Inner {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
	
	// 자바 8 이후
	public void method2(int arg) {
		int localVariable = 1;
//		arg = 100;
//		localVariable = 100;
		class Inner {
			public void method () {
				int result = arg + localVariable;
				// 메소드 내부의 지역변수는 final이 된다.
				// 따라서 한번 할당된 변수의 값은 초기화가 불가능함.
			}
		}
	}
}

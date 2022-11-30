package project_1130;

public class Aaa {

	int a;
	int b;
	int c;

	Aaa() {

	}
	
	Aaa(int a) {
//		this.a = a;
		this(a,0,0);
		// 아랫쪽의 parameter 3개를 받는 메소드를 이곳에서 호출
	}
	
	Aaa(int b, int c) {
//		this.b = b;
//		this.c = c;
		this(0,b,c);
	}
	
	Aaa(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

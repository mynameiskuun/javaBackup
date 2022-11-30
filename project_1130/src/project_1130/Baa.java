package project_1130;

public class Baa {

	int a;
	
	void bbb() {
		System.out.println(a);
	}
	int ccc() {
		return 10;
	}
	
	void ddd(int a) {
//		System.out.println(a);
//		bbb();
		this.bbb();
	}
	
	int eee(int a) {
		return 20;
	}
	
	void Calculator() {
		
	}
	
	public static void main(String[] args) {
		
		Baa asd = new Baa();
		asd.bbb();
		System.out.println(asd.ccc());
	
		
	}
}

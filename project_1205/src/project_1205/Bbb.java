package project_1205;

class Ccc {
	
	String asd;
	int sdf;
	
	Ccc() {
		
	}
	
	Ccc(String a, int b) {
		this.asd = a;
		this.sdf = b;
	}
	
	final void asd() {
		System.out.println("안녕");
	}
	
}
public class Bbb extends Ccc{
	public static void main(String[] args) {

		Ccc c1 = new Ccc();
		Bbb b1 = new Bbb();
		Aaa a1 = new Aaa();
		
		c1.asd();
	}

	private void b1(String string, int i) {
		this.asd = string;
	}

	private void c1(String string, int i) {
		this.sdf = i;
	}

}

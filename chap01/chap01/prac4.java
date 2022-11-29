package chap01;

public class prac4 {

	public static void main(String[] args) {
	boolean run = true;
		
	for(int x=1; x<=10; x++) {
		for(int y=1; y<=10; y++) {
			if(4*x+5*y==60) {
				System.out.println("("+x+","+y+")");
			}
		}
	}

	}

}

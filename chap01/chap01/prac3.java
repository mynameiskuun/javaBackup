package chap01;

public class prac3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean run = true;

				while(run) {
					int a = (int)(Math.random() * 6 + 1);
					int b = (int)(Math.random() * 6 + 1);
					if((a+b)!=5) {
						System.out.println("("+a+","+b+")");
					} else if(a+b==5)
						run=false;
				}
				
		
		}
	

}

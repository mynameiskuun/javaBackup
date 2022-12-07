package DefaultEx;

public class IEX {

	public static void main(String[] args) {
//		I.d();
		I i = new I() {
			public void d() {
				System.out.println("dd");
				// 인터페이스의 default 메소드는 재정의가 가능하다.
			}
		};
		                                                                                                                                                                                      
		i.d();
		
		Cls c1 = new Cls();
		c1.d();
	}

}

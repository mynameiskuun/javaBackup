package project_1222;

public class prj01 {

	public static void main(String[] args) {
		Test t = (e)->{
//			System.out.println(e);
			return Integer.parseInt(e);
					};
			int num = t.m("10");
			System.out.println(num);
			
	}
}

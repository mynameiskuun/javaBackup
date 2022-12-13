package project_1212;

public class ExcepEx {

	public static void main(String[] args) {
		try {
			test();
		} catch(CustomException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static void test() throws CustomException {
		throw new CustomException("예외 테스트 입니다");
	}
}

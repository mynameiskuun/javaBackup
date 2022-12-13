package project_1212;

public class NulpoEx {
	public static void main(String[] args) {
		String data = null;
		try {
		System.out.println(data.toString());
		} catch(NullPointerException ev) {
//			ev.printStackTrace();
			System.out.println(ev.getMessage());
			data = "test";
			System.out.println(data.toString());
		}
	}
}

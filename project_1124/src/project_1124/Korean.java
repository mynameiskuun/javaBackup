package project_1124;

public class Korean {

	String nation = "대한민국";
	String name;
	String ssn;

	// 생성자
	public Korean(String n, String s) {
		name = n;
		ssn = s;
	}

	public Korean(String n, String s, String na) {
		name = n;
		ssn = s;
		nation = na;
	}

	public static void main(String[] args) {
		
		Korean k1 = new Korean("미국", "월드컵 못나옴");
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		Korean k2 = new Korean("ㅁㅁ", "ㄴㄴ", "ㅈㅈ");
			System.out.println(k2.name);
			System.out.println(k2.ssn);
			System.out.println(k2.nation);
	}
}

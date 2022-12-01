
public class MemberService {

	String id = "hong";
	String password = "12345";
	
	boolean login(String id, String password) {
		this.id = id;
		this.password = password;
		
		if(id.equals(this.id) && password.equals(this.password)) {
			return true;
		} else {
			return false;
		}
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다");
	}
}

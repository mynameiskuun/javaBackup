
public class MemberService {

	String id = "hong";
	String password = "12345";
	
	boolean login(String id, String password) {
//		this.id = id;
//		this.password = password;
		
// 		위의 두줄의 코드의 의미는, 파라미터로 입력받은 값이 클래스의 id값이 된다 는 뜻.
//  	따라서 파라미터로 입력받은 값이, 바로 메소드의 if문으로 들어갈 수 있게해야함.
//		위의 두줄의 코드는 필요 없다는 
		
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

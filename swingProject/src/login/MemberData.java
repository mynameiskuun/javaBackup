package login;

// 수강생 데이터
public class MemberData {

	int key;
	String id;
	String password;
	String phonenumber;
	String name;
	String birthday;
	String nickname;
	String coursename;

	public MemberData(int key, String id, String password, String phonenumber, String name, String birthday,
			String nickname, String coursename) {
		super();
		this.key = key;
		this.id = id;
		this.password = password;
		this.phonenumber = phonenumber;
		this.name = name;
		this.birthday = birthday;
		this.nickname = nickname;
		this.coursename = coursename;
	}

	@Override
	public String toString() {
		return "MemberData [key=" + key + ", id=" + id + ", password=" + password + ", phonenumber=" + phonenumber
				+ ", name=" + name + ", birthday=" + birthday + ", nickname=" + nickname + ", coursename=" + coursename
				+ "]";
	}

}
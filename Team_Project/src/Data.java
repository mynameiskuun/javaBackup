public class Data {
	String name;// 이름
	String id;// 아이디
	String password;// 비밀번호
	String birth;// 생년월일
	String ninkName;// 닉네임
	String coursName;// 강좌명
	String phoneNumber; // 핸드폰 번호
	
	public Data() {
	}

	public Data(String name) {
		super();
		this.name = name;
	}

	public Data(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public Data(String name, String id, String password, String birth, String ninkName) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.birth = birth;
		this.ninkName = ninkName;
	}

	public Data(String name, String id, String password, String birth, String ninkName, String coursName) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.birth = birth;
		this.ninkName = ninkName;
		this.coursName = coursName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getNinkName() {
		return ninkName;
	}

	public void setNinkName(String ninkName) {
		this.ninkName = ninkName;
	}

	public String getCoursName() {
		return coursName;
	}

	public void setCoursName(String coursName) {
		this.coursName = coursName;
	}

}
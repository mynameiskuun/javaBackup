package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//메소드명 서로 겹치치 말기...



public class JDBC {
	// Connection은 데이터베이스와 연결하는 객체이다.
	Connection conn = null;
	// ResultSet : 실행한 쿼리문의 값을 받는 객체
	ResultSet rs = null;
	// 그냥 가져오는거
	Statement stmt;
	// PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
	PreparedStatement pstm = null; // ?넣어서 집어넣는거
	ResultSetMetaData rsmd;
	final int COL_LENGTH = 8;
	// 생성자
	public JDBC() {

		try {
			String user = "java";
			String pw = "mysql";
			String url = "jdbc:mysql://localhost:3306/joongang";

			// jdbc drive를 등록하는 과정
			// class.forName을 호출하면 Driver가 자기자신을 초기화하여 DriverManager에 등록한다.
			// 즉, 개발자가 따로 관리하지 않는 static 객체들이 알아서 DriverManager에 등록되는 것이다.
			// 그래서 Class.forName()을 호출하고 나서 어떤 인자로도 전달하지 않고 바로 getConnection()을 호출해도 드라이버가
			// 찾아진다.

			// Driver Class를 로딩하면 객체가 생성되고, DriverManager에 등록된다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("접속성공");
			// connection으로 db와 연결 (객체 생성)
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
	}

	// 사용하지 않는 자원이 유지 되기 때문에 자원이 낭비된다.
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstm != null)
				pstm.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}

	// 로그인
	boolean checkId(String id1, String password) throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from student");
		boolean flag = false;
		String id = id1;
		String pw = password;
		try {
			String checkingStr = "SELECT password FROM student WHERE id = '" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			System.out.println(checkingStr);

			while (result.next()) {
				if (pw.equals(result.getString("password"))) {
					flag = true;
					System.out.println("로그인 성공");
				} else {
					flag = false;
					System.out.println("로그인 실패");
				}
			}

		} catch (Exception e) {
			flag = false;
			System.out.println("로그인 실패 >" + e.toString());
		}
		dbClose();
		return flag;
	}

	

//테이블-------------------------------------------------------------------
// 테이블 행 개수 가져오기
String[] showDBColsDataCI() throws SQLException {
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from joongang.courselist");
	rsmd = rs.getMetaData();
	int cols = rsmd.getColumnCount();
	String[] colNameData = new String[cols];
	for (int i = 0; i < cols; i++) {
		colNameData[i] = rsmd.getColumnName(i + 1);
	}
	System.out.println(colNameData);
	return colNameData;
}

// 테이블 컬럼 별칭 설정
String[] showDBcolsCI() throws SQLException {
	String[] dataToKor = showDBColsDataCI();
	for (int i = 0; i < dataToKor.length; i++) {
		if (dataToKor[i].equals("coursekey")) {
			dataToKor[i] = "No";
		} else if (dataToKor[i].equals("courseNum")) {
			dataToKor[i] = "강좌번호";
		} else if (dataToKor[i].equals("courseName")) {
			dataToKor[i] = "강좌명";
		} else if (dataToKor[i].equals("instructor")) {
			dataToKor[i] = "강사명";
		} else if (dataToKor[i].equals("fixedNum")) {
			dataToKor[i] = "정원";
		} else if (dataToKor[i].equals("period")) {
			dataToKor[i] = "수강 기간";
		} else if (dataToKor[i].equals("courseInfo")) {
			dataToKor[i] = "수강강좌 정보";
		}
	}
	return dataToKor;
}

// 이중배열 만들기
ArrayList getDBAllRowsCI() throws SQLException {
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from joongang.courselist");
	ArrayList<String[]> rowListCI = addCourseRows();
	return rowListCI;
}
ArrayList getDBAllRowsUI() throws SQLException {
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from joongang.student");

	ArrayList<String[]> rowListUI = addUIRows();
	return rowListUI;
}

// 배열에 값 넣어주기
private ArrayList<String[]> addCourseRows() throws SQLException {
	ArrayList<String[]> rowList = new ArrayList<String[]>();
	while (rs.next()) {
		String[] rows = new String[8];
		rows[0] = String.valueOf(rs.getInt("coursekey"));
		rows[1] = rs.getString("courseNum");
		rows[2] = rs.getString("courseName");
		rows[3] = rs.getString("instructor");
		rows[4] = rs.getString("fixedNum");
		rows[5] = rs.getString("period");
		rows[6] = rs.getString("courseInfo");
		rowList.add(rows);
	}
	return rowList;
}


MemberData selectUI(String sstr) {
	String sql = "select * from joongang.student where id = ?";
	try {
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, sstr);
		rs = pstm.executeQuery();
		if (rs.next()) {
			int key = rs.getInt("no");
			String id = rs.getString("id");
			String password = rs.getString("password");
			String phonenumber = rs.getString("phoneNumber");
			String name = rs.getString("name");
			String birthday = rs.getString("birth");
			String nickname = rs.getString("nickname");
			String coursename = rs.getString("coursename");

			return new MemberData(key, id, password, phonenumber, name, birthday, nickname, coursename);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

// 수강신청 시
void update(String coursName, String accountId) throws SQLException {

	Statement stmt = conn.createStatement();
	int result = stmt.executeUpdate(
			"UPDATE joongang.student SET coursename = '" + coursName + "' where id ='" + accountId + "'");
	System.out.println(result + "건");

}

void updatePw(String password, String accountId) throws SQLException {
	stmt = conn.createStatement();
	int result = stmt.executeUpdate(
			"UPDATE joongang.student SET password = '" + password + "' where id ='" + accountId + "'");
	System.out.println(result + "건");

}


//-----------------------------------------------------------------------------

// 수강정보 가져오는 부분
String selectCI(String aa) {
	
	String sql = "select coursekey, courseNum, courseName, instructor, fixedNum, period, courseInfo from joongang.courselist where courseName ='"
			+ aa + "'";

	String courseData;
	try {
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery();
		while (rs.next()) {
			courseData =" 강좌명: " + rs.getString("courseName")+ "\t \t \t 강사명: " + rs.getString("instructor") + "\n 수강기간: "
					+ rs.getString("period") + "\t 수강정보: " + rs.getString("courseInfo");
					return courseData;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
///찬호

String[] showDBColsDataUI() throws SQLException {

	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from joongang.student");
	rsmd = rs.getMetaData();
	int cols = rsmd.getColumnCount();
	String[] colNameData = new String[COL_LENGTH];
	for (int i = 0; i < COL_LENGTH; i++) {
		colNameData[i] = rsmd.getColumnName(i + 1);
	}
	return colNameData;
}

String[] showDBcolsUI() throws SQLException {
	String[] dataToKor = showDBColsDataUI();
	for (int i = 0; i < COL_LENGTH; i++) {
		if (dataToKor[i].equals("no")) {
			dataToKor[i] = "No";
		} else if (dataToKor[i].equals("id")) {
			dataToKor[i] = "아이디";
		} else if (dataToKor[i].equals("password")) {
			dataToKor[i] = "비밀번호";
		} else if (dataToKor[i].equals("phonenumber")) {
			dataToKor[i] = "전화번호";
		} else if (dataToKor[i].equals("name")) {
			dataToKor[i] = "이름";
		} else if (dataToKor[i].equals("birth")) {
			dataToKor[i] = "생년월일";
		} else if (dataToKor[i].equals("nickname")) {
			dataToKor[i] = "닉네임";
		} else if (dataToKor[i].equals("coursename")) {
			dataToKor[i] = "수강명";
		}
	}
	return dataToKor;
}

ArrayList showSearchRows(String comboBoxValue, String inputText) throws SQLException {
	int inputToInt;
	String inputToString;
	stmt = conn.createStatement();

	if (comboBoxValue.equals("No")) {
		comboBoxValue = "no";
		inputToInt = Integer.parseInt(inputText);
		String sql = "select * from student where " + comboBoxValue + " = " + inputToInt;
		rs = stmt.executeQuery(sql);
		ArrayList<String[]> rowList = addUIRows();
		return rowList;

	} else if (comboBoxValue.equals("이름")) {
		comboBoxValue = "name";
		inputToString = inputText;
		String sql = "select * from student where " + comboBoxValue + " like '%" + inputToString + "%'";
		rs = stmt.executeQuery(sql);
		ArrayList<String[]> rowList = addUIRows();
		return rowList;

	} else if (comboBoxValue.equals("아이디")) {
		comboBoxValue = "id";
		inputToString = inputText;
		String sql = "select * from student where " + comboBoxValue + " = '" + inputToString + "'";
		rs = stmt.executeQuery(sql);
		ArrayList<String[]> rowList = addUIRows();
		return rowList;

	} else if (comboBoxValue.equals("비밀번호")) {
		comboBoxValue = "password";
		inputToString = inputText;
		String sql = "select * from student where " + comboBoxValue + " = '" + inputToString + "'";
		rs = stmt.executeQuery(sql);
		ArrayList<String[]> rowList = addUIRows();
		return rowList;

	} else if (comboBoxValue.equals("전화번호")) {
		comboBoxValue = "phoneNumber";
		inputToString = inputText;
		String sql = "select * from student where " + comboBoxValue + " like '%" + inputToString + "%'";
		rs = stmt.executeQuery(sql);
		ArrayList<String[]> rowList = addUIRows();
		return rowList;

	} else if (comboBoxValue.equals("생년월일")) {
		comboBoxValue = "birth";
		inputToString = inputText;
		String sql = "select * from student where " + comboBoxValue + " = '" + inputToString + "'";
		rs = stmt.executeQuery(sql);
		ArrayList<String[]> rowList = addUIRows();
		return rowList;

	} else if (comboBoxValue.equals("닉네임")) {
		comboBoxValue = "nickName";
		inputToString = inputText;
		String sql = "select * from student where " + comboBoxValue + " = '" + inputToString + "'";
		rs = stmt.executeQuery(sql);
		ArrayList<String[]> rowList = addUIRows();
		return rowList;

	} else if (comboBoxValue.equals("수강명")) {
		comboBoxValue = "courseName";
		inputToString = inputText;
		String sql = "select * from student where " + comboBoxValue + " like '%" + inputToString + "%'";
		rs = stmt.executeQuery(sql);
		ArrayList<String[]> rowList = addUIRows();
		return rowList;
	}
	return null;

}

	

	private ArrayList<String[]> addUIRows() throws SQLException {
		ArrayList<String[]> rowList = new ArrayList<String[]>();
		while (rs.next()) {
			String[] rows = new String[COL_LENGTH];
			rows[0] = String.valueOf(rs.getInt("no"));
			rows[1] = rs.getString("id");
			rows[2] = rs.getString("password");
			rows[3] = rs.getString("phoneNumber");
			rows[4] = rs.getString("name");
			rows[5] = rs.getString("birth");
			rows[6] = rs.getString("nickName");
			rows[7] = rs.getString("courseName");
			rowList.add(rows);
		}
		return rowList;
	}

	public int updateDB(int no, String name, String id, String password, String phoneNumber, String birth,
			String nickName, String courseName) throws SQLException {
		// TODO Auto-generated method stub
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("update student set name = '" + name + "', id = '" + id + "', password = '"
				+ password + "', phoneNumber = '" + phoneNumber + "', birth = '" + birth + "', nickName = '" + nickName
				+ "', courseName = '" + courseName + "' where no = " + no);
		return result;
	}

	public int deleteDB(int no, String name, String id, String password, String phoneNumber, String birth,
			String nickName, String courseName) throws SQLException {
		// TODO Auto-generated method stub
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("delete from student where no = " + no);
		return result;
	}

	public int insertDB(String name, String id, String password, String phoneNumber, String birth, String nickName,
			String courseName) throws SQLException {
		// TODO Auto-generated method stub
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("insert into student values(0, '" + name + "', '" + id + "', '" + password
				+ "', '" + phoneNumber + "', '" + birth + "', '" + nickName + "', '" + courseName + "')");
		return result;
	}

	
	
}

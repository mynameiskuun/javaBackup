package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	Jdbc() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
		System.out.println("접속 완료");
	}
	
	void selectAll() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from student");
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String hakbun = rs.getString("hakbun");
			String address = rs.getString("address");
			System.out.printf("[%d] %s\n", id, name, hakbun, address);
		}
	}
	
	void insert(String name, String hakbun, String address) throws SQLException{
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("insert into student values(0,'"+name+"','"+hakbun+"','"+address+"')");
		System.out.println(result + "건 입력 성공");
	}
	
	void update(String name, String hakbun, String address, int id) throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("update student set name = '"+name+"', hakbun = '"+hakbun+"', address = '"+address+"' where id = "+id);
		System.out.println(result + "건 수정 성공");
	}
	
	void delete(String name) throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("delete from student where name = '"+name+"'");
		System.out.printf("%s의 자료를 %d건 삭제\n",name,result);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Jdbc sd = new Jdbc();
		sd.selectAll();
		sd.insert("김길동", "202288", "서울 강남구");
		sd.update("홍길동", "202277", "서울 영등포구", 11);
		sd.delete("김길동");
	}
}


// jdbc 중요한 문법 String 변수를 적을때는 '"+name+"' 과 같이 적어야 함.
// int 변수 적을때에는, 큰따옴표 밖으로 빼서
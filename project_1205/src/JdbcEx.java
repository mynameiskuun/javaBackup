import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcEx {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	Scanner scan = new Scanner(System.in);
	
	

	public static void update(String name, String hakbun, String address) throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("update student values(0,'"+name+"','"+hakbun+"','"+address+"')");
		System.out.println(result + "건 입력 성공");
	}
	
	public static void insert(String name, String hakbun, String address) throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate("insert into student values(0,'"+name+"','"+hakbun+"','"+address+"')");
		System.out.println(result + "건 입력 성공");
	}

	public static void connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 완료");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
		System.out.println("접속확인");
	}

	public static void selectAll() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from student");
		while (rs.next()) {
			String name = rs.getString("name");
			String hakbun = rs.getString("hakbun");
			String address = rs.getString("address");
			int ID = rs.getInt("ID");
			System.out.println(name + ", " + hakbun + ", " + address + ", " + ID);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		connect();
		insert("박익명","202210","서울 광진구");
		selectAll();
		update("","","");
	}
}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx1 {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void insert(String name, String hakbun, String address) throws SQLException {
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(
		"insert into student values(0,'"+name+"','"+hakbun+"','"+address+"')");
		System.out.println(result+"건 입력 성공");
	}
	public static void connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 설치 완료");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
		System.out.println("접속 완료");
	}
	
	public static void selectAll() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from student");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String hakbun = rs.getString("hakbun");
			String address = rs.getString("address");
			System.out.println(id + "," + name + "," + hakbun + "," + address);
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		connect();
		insert("김사랑","202206","성동구");
		selectAll();
	}

}
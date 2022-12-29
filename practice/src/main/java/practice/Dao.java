package practice;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;



public class Dao {
	private Connection conn = getConnect();
	
	private Connection getConnect() {
		try {
			Properties properties = new Properties();
			String path = PropertiesExample.class.getResource("db.properties").getPath();
			// EmpDao 클래스 파일이 존재하는 디렉토리의 db.properties라는 경로를 path라는 변수에 저장한다.
			path = URLDecoder.decode(path, "utf-8");
			// 혹시 경로에 한글이 있을 경우 한글을 복원시킨다.(디렉토리 경로)
			properties.load(new FileReader(path));
			// 클래스 파일이 위치한 경로에서 db.properties라는 파일을 읽는다.
			String driver = properties.getProperty("driver");
			System.out.println(driver);
			Class.forName(driver);
			String url = properties.getProperty("url");
			System.out.println(url);
			String username = properties.getProperty("username");
			System.out.println(username);
			String password = properties.getProperty("password");
			System.out.println(password);
			
//			String url1 = "jdbc:oracle:thin:@localhost:1521:xe";
//			String user = "scott", pw = "tiger";
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public void insert() {
		String sql = "insert into table1 (KEY, ID, NAME) values (? , ? , ?)";
		Connection conn;
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery(sql);
	}
}

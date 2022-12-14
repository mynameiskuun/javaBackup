package project_1214;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	void connection() {
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choongang", "root", "mysql");
				System.out.println("DB연결 성공");
			} catch (Exception e) {
				System.out.println("DB연결 에러발생" + e.getMessage());
			}
		}
	}
	
	int insert(Student stu) {
		String sql = "insert into student1(name,hakbun,address) values (0,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, stu.name);
			pstm.setString(2, stu.hakbun);
			pstm.setString(3, stu.addr);
			return pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
	List<Student> select() {
		List<Student> lst = new ArrayList<Student>();
		String sql = "select id,name,hakbun,address from student1";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Student stu = new Student (
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4));
					
				lst.add(stu);
				
				System.out.print(rs.getString(1)+", ");
				System.out.print(rs.getString(2)+", ");
				System.out.print(rs.getString(3)+", ");
				System.out.println(rs.getString(4));
				
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		dao.connection();
		List<Student> list = dao.select();
		for(Student stu : list) {
			System.out.println(stu);
		}
//		stu.select();
//		int res = stu.insert(new Student(999,"asd","asd","asd"));
//		System.out.println(res + "건 입력 완료!");
	}
}

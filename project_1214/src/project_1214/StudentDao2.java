package project_1214;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao2 {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
			System.out.println("DB 접속!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	int insert(Student stu) {
		String sql = "insert into student1(name, hakbun, address) values (?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, stu.name);
			pstm.setString(2, stu.hakbun);
			pstm.setString(3, stu.addr);
			return pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		String sql = "select id, name, hakbun, address from student1";
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				Student stu = new Student(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4));
				lst.add(stu);
//				System.out.print(rs.getInt(1)+", ");
//				System.out.print(rs.getString(2)+", ");
//				System.out.print(rs.getString(3)+", ");
//				System.out.println(rs.getString(4));
			}
			return lst;
		} catch (SQLException e) {
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
//		int res = 
//		  dao.insert(new Student(999, "김기쁨", "202205", "강남구"));
//		System.out.println(res+"건 입력!");
	}

}



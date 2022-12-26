package jdbc;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmpDao {
	private Connection conn = getConnect();

	private static EmpDao empDao = new EmpDao();

	public static EmpDao getInstance() {
		return empDao;
	}

	private EmpDao() {
	}

	private Connection getConnect() {
		try {
			Properties properties = new Properties();
			String path = EmpDao.class.getResource("db.properties").getPath();
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
	public Emp select(int num) {
		String sql = "select * from emp where empno = ?";
		Emp emp = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int mgr = rs.getInt("mgr");
				int comm = rs.getInt("comm");
//				System.out.printf("%d %s %s %d %d\n", empno, ename, job, deptno, sal);
				emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);

			}
			rs.close();
			pstm.close();
			return emp;
			
//			return 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	public List<Emp> selectAll(int num) {
		List<Emp> lst = new ArrayList<>();
		
		String sql = null;
		switch(num) {
		case 0:  // 정렬 안함
			sql = "select * from emp";
			break;
		case 1:  // 부서별 오름차순
			sql = "select * from emp order by deptno";
			break;
		case 2:  // 부서별 내림차순
			sql = "select * from emp order by deptno desc";
			break;
		}
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int mgr = rs.getInt("mgr");
				int comm = rs.getInt("comm");
//				System.out.printf("%d %s %s %d %d\n", empno, ename, job, deptno, sal);
				Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				lst.add(emp);
			}
			rs.close();
			pstm.close();
			return lst;
			
//			return 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	public List<Emp> selDeptSvg() {
		List<Emp> lst = new ArrayList<>();
		
		String sql = "select deptno, job, avg(sal) as avg_sal"
				+ " from emp "
				+ "group by deptno, job "
				+ "order by deptno, job";

//		switch(num) {
//		case 0:  // 정렬 안함
//			sql = "select * from emp";
//			break;
//		case 1:  // 부서별 오름차순
//			sql = "select * from emp order by deptno";
//			break;
//		case 2:  // 부서별 내림차순
//			sql = "select * from emp order by deptno desc";
//			break;
//		}
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int empno = 0;
				String ename = null;
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("avg_sal");
				String hiredate = null;
				int mgr = 0;
				int comm = 0;
				System.out.printf("%d %s %s %d %d\n", empno, ename, job, deptno, sal);
				Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				lst.add(emp);
			}
			rs.close();
			pstm.close();
			return lst;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	public static void main(String[] args) {
		EmpDao ef = EmpDao.getInstance();
		// 객체 생성 방법이 아닌 싱글톤 생성 방법.
//		for(Emp emp : ef.selectAll(0)) {
//			System.out.println(emp);
//		}
		List<Emp> lst = ef.selectAll(0);
		lst.stream().forEach(n->System.out.println(n));
		
		double avg = lst.stream().mapToInt(Emp::getSal).average().getAsDouble();
		System.out.println(avg);
	
	
	}
}

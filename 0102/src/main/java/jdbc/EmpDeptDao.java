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

public class EmpDeptDao {
	public List<Emp> lst;
	public List<Dept> dlst;
	
	private Connection getConnect() {
		try {
			Properties prop = new Properties();
			String path = EmpDeptDao.class.getResource("db.properties").getPath();
			path = URLDecoder.decode(path, "utf-8");
			prop.load(new FileReader(path));
			String driver = prop.getProperty("driver");
			Class.forName(driver);
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pw = prop.getProperty("pw");
			Connection conn = DriverManager.getConnection(url, user, pw);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};

	public List<Emp> realSelectAll() {
		lst = new ArrayList<>();

		String sql = "select * from emp_temp";
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
				Emp emp = new Emp(empno, ename, job, deptno, hiredate, sal, mgr, comm);
				lst.add(emp);
			}
			rs.close();
			pstm.close();
			return lst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		return null;
	}

	public List<Emp> selectAll(int num) {
		List<Emp> lst2 = new ArrayList<>();
		switch (num) {
		case 0: // 정렬 안함
			return lst;
		case 1: // 부서별 오름차순
			lst.stream().sorted().sorted((n1, n2) -> n1.getDeptno() - n2.getDeptno()).forEach(n -> lst2.add(n));
			return lst2;
		case 2: // 부서별 내림차순
			lst.stream().sorted().sorted((n1, n2) -> n2.getDeptno() - n1.getDeptno()).forEach(n -> lst2.add(n));
			return lst2;
		}
		return lst2;
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
				emp = new Emp(empno, ename, job, deptno, hiredate, sal, mgr, comm);
			}
			rs.close();
			pstm.close();
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Connection conn = getConnect();

	private static EmpDeptDao empDao = new EmpDeptDao();

	public static EmpDeptDao getInstance() {
		return empDao;
	}

	public int insertDeptTemp(Dept dept) {
		String sql = "insert into dept_temp (deptno, dname, loc)"
				 	+ "values (?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dept.getDeptno());
			pstm.setString(2, dept.getDname());
			pstm.setString(3, dept.getLoc());
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
			
		} catch(SQLException e) {
			e.printStackTrace();
		};
		return 0;
	}

	public int insertEmpTemp(Emp emp) {
		String sql = "insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)"
				 	+ "values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, emp.getEmpno());
			pstm.setString(2, emp.getEname());
			pstm.setString(3, emp.getJob());
			pstm.setInt(4, emp.getMgr());
			pstm.setString(5, emp.getHiredate());
			pstm.setInt(6, emp.getSal());
			pstm.setInt(7, emp.getComm());
			pstm.setInt(8, emp.getDeptno());
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
			
		} catch(SQLException e) {
			e.printStackTrace();
		};
		return 0;
	}
	
	public List<Dept> selectDept() {
		dlst = new ArrayList<>();
		
		String sql = "select * from dept_temp order by deptno";
		try {
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			Dept dept = new Dept(deptno, dname, loc);
			dlst.add(dept);
		}
		rs.close();
		pstm.close();
		return dlst;
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return null;
	}
}

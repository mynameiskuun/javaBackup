package jdbc;

public class Emp implements Comparable<Emp>{
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	public Emp(int empno, String ename, String job, int deptno, String hiredate, int sal, int mgr, int comm) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	@Override
	public String toString() {
		return "사원정보 [사원번호=" + empno + ", 사원명=" + ename + ", 직무=" + job + ", 입사일=" + hiredate + ", 급여=" + sal
				+ ", 수당 =" + comm + ", 부서번호=" + deptno + "]";
	}

	@Override
	public int compareTo(Emp o) {
		return Integer.compare(empno, o.empno);
	}
	
	
}

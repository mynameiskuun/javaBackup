package jdbc;

import java.util.stream.IntStream;

public class EmpDaoEx {

	public static void main(String[] args) {
		EmpDao ed = EmpDao.getInstance();
//		Dept dept = new Dept(60,"ACCOUNT","INCHEON");
//		int res = ed.insertEmpTemp(dept);
//		System.out.println(res);
		
		IntStream.rangeClosed(1,10)
		.forEach(n-> {
			int res = ed.insertDeptTemp(new Dept(n*2,"회계"+n,"인천"+n));
			System.out.println(res);
		});
	}
}

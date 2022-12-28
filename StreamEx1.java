package jdbc;

import java.util.List;
import java.util.stream.IntStream;

public class StreamEx1 {

	public static void main(String[] args) {
		
		
		EmpDao ed = EmpDao.getInstance();
		List<Emp> lst = ed.selectAll(0);
//		for (Emp emp : lst) {
//			System.out.println(emp);
//		}
		
		IntStream.rangeClosed(1, 5).forEach(n->{
		System.out.println("****");
		System.out.println(n+"test");
	});
		
		lst.stream().filter(n->n.getEname().startsWith("K"))
		.forEach(n->System.out.println(n));
		System.out.println("----------------------------");
		lst.stream().filter(n->n.getSal() >= 2000)
		.forEach(n->System.out.println(n));
	}
}

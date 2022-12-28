package jdbc;

import java.util.Arrays;
import java.util.List;

public class StreamEx2 {
	
	public static void main(String[] args) {
		
		EmpDao ed = EmpDao.getInstance();
		List<Emp> lst = ed.selectAll(0);
		List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
		
		inputList1.stream().flatMap(data -> Arrays.stream(data.split(" ")))
		.forEach(word -> System.out.println(word));
		
		System.out.println(inputList1.size());
		System.out.println();
		System.out.println("--------------------------------");
		
		
		
		
		List<String> inputList2 = Arrays.asList("10,20,30","40,50,60");
		inputList2.stream().flatMapToInt(data -> {
			String[] strArr = data.split(",");
			
			for(String ss : strArr) {
				System.out.println(ss);
			}
			
			System.out.println("----------------------------------2");
			
			int[] intArr = new int[strArr.length];
			for(int i=0; i<strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		})
		.forEach(number -> System.out.println(number));
		System.out.println("--사번으로 정렬--");
		lst.stream().sorted().forEach(n->System.out.println(n));
		System.out.println("--부서별 정렬--");
		lst.stream().sorted((n1,n2)->n1.getDeptno()-n2.getDeptno()).forEach(n->System.out.println(n));
		
		
	}

}

package jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class StreamEx2 {

	public static void main(String[] args) {

		EmpDao ed = EmpDao.getInstance();
		List<Emp> lst = ed.selectAll(0);
		List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");

		inputList1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(word -> System.out.println(word));

		System.out.println(inputList1.size());
	
		System.out.println("--------------문자열 자르기---------------");

		List<String> inputList2 = Arrays.asList("10,20,30", "40,50,60");
		inputList2.stream().flatMapToInt(data -> {
			String[] strArr = data.split(",");
			
			System.out.println(strArr.length);
			
			for (String ss : strArr) {
				System.out.println(ss);
			}

			System.out.println("-----------------숫자 자르기-----------------2");

			int[] intArr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		}).forEach(number -> System.out.println(number));
		
		System.out.println("---------------사번으로 정렬-----------------");
		lst.stream().sorted().forEach(n -> System.out.println(n));
		System.out.println("-----------------부서별 정렬------------------");
		lst.stream().sorted((n1, n2) -> n1.getDeptno() - n2.getDeptno())
				.forEach(n -> System.out.println(n.getEmpno() + "," + n.getDeptno()));

		System.out.println("-------------------루핑---------------------");
		List<Emp> dept10 = new ArrayList<>();
		
		double avg = lst.stream().filter(a -> a.getDeptno() == 10).peek(n -> dept10.add(n)).mapToInt(Emp::getSal)
				.average().getAsDouble();
			
		dept10.stream().forEach(x->System.out.println(x));
		System.out.println("평균: " + avg);
		
		
		System.out.println("----------------Optional----------------");
		List<Integer> list = new ArrayList<>();
		double avg2 = list.stream()
				.mapToInt(Integer::intValue)
				.average().orElse(0.0);
		System.out.println(avg2);
		
		list.stream().mapToInt(Integer::intValue).average()
		.ifPresent(a->System.out.println(a));
		
		OptionalDouble opt = list.stream()
				.mapToInt(Integer::intValue)
				.average();
		if(opt.isPresent()) {
			System.out.println("ok");
		} else {
			
			System.out.println("null");
		}
	}

}

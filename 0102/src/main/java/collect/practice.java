package collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class practice {

	public static void main(String[] args) {
		List<Student> lst = new ArrayList<>();
		lst.add(new Student("홍",20,Student.Sex.MALE,Student.City.Pusan));
		lst.add(new Student("김",60,Student.Sex.FEMALE,Student.City.Seoul));
		lst.add(new Student("박",99,Student.Sex.MALE,Student.City.Pusan));
		lst.add(new Student("최",77,Student.Sex.FEMALE,Student.City.Seoul));
		
		List<Student> lst2 = Arrays.asList(
				new Student("홍",40,Student.Sex.MALE,Student.City.Pusan),
				new Student("김",12,Student.Sex.FEMALE,Student.City.Seoul),
				new Student("최",60,Student.Sex.MALE,Student.City.Pusan),
				new Student("임",99,Student.Sex.FEMALE,Student.City.Seoul)
				);
		
		List<Student> maleList = lst2.stream().filter(s -> s.getSex() == Student.Sex.FEMALE)
				.collect(Collectors.toList());
		
		System.out.println(maleList);
		
	}
}

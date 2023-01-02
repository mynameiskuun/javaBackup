package collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToListEx2 {

	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(new Student("홍", 10, Student.Sex.MALE),
				new Student("김", 66, Student.Sex.FEMALE), new Student("박", 33, Student.Sex.MALE),
				new Student("신", 22, Student.Sex.FEMALE));
		List<Student> maleList = totalList.stream().filter(s -> s.getSex() == Student.Sex.MALE)
				.collect(Collectors.toList());

		
		maleList.stream().forEach(s->System.out.println(s.getName()));
		
	}

}

package collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToListEx {

	public static void main(String[] args) {
		List<Student> tt2 = new ArrayList<>();	
		tt2.add(new Student("홍", 10, Student.Sex.MALE, Student.City.Seoul));
		// 객체 생성 후 add 메소드의 파라미터에 객체를 전달 해 값을 입력하는 방식.
		
		List<Student> totalList = Arrays.asList(
				new Student("홍", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student("김", 66, Student.Sex.FEMALE, Student.City.Pusan), 
				new Student("박", 33, Student.Sex.MALE, Student.City.Seoul),
				new Student("최", 22, Student.Sex.FEMALE, Student.City.Pusan));
		
		List<Student> maleList = totalList.stream().filter(s -> s.getSex() == 
				Student.Sex.MALE).collect(Collectors.toList());
		// 객체 생성과 동시에 값을 입력하는 방식. asList 사용
		
		Map<Student.Sex, List<Student>> ms = totalList.stream()
				.collect(Collectors.groupingBy(Student::getSex));
		// key와 value로 이루어진 Map 자료구조. 
		ms.get(Student.Sex.MALE).stream().forEach(s->System.out.println(s.getName()));
		
		Map<Student.City, List<String>> ms2 = totalList.stream()
				.collect(Collectors.groupingBy(Student::getCity,
						Collectors.mapping(Student::getName, Collectors.toList())));
		
		ms2.get(Student.City.Seoul).stream().forEach(s->System.out.println(s));
		
		Map<Student.Sex, Double> ms3 = totalList.stream()
				.collect(Collectors.groupingBy(Student::getSex, 
						Collectors.averagingDouble(Student::getScore)));
		// 성별 별로 평균점수 값 계산하기
		System.out.println(ms3.get(Student.Sex.MALE));
		// 남학생 평균점수
		
		Map<Student.Sex, String> ms4 = totalList.stream()
				.collect(Collectors.groupingBy(Student::getSex, 
						Collectors.mapping(Student::getName, Collectors.joining(", "))));
		// 성별 별로 그룹핑 한 뒤, mapping 메소드를 통하여 성별 별로 1차원 배열 화 시킨다.
		// 해당 elements 사이에 ", "를 joining 시킨다.
		System.out.println(ms4.get(Student.Sex.FEMALE));
		}

}

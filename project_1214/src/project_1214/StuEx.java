package project_1214;

import java.util.ArrayList;
import java.util.List;

public class StuEx {
		
	public static void main(String[] args) {
		List<Student> lst = new ArrayList<Student>();
		
		Student stu = new Student(0,"asd1","asd2","asd3");
		lst.add(stu);
		lst.add(new Student(1,"","",""));
		lst.add(new Student(2,"","",""));
		
		for(Student st : lst) {
			System.out.println(st);
			System.out.println(st.name);
		}
		System.out.println(lst.size());
		
	}
}

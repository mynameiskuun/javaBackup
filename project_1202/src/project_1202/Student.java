package project_1202;

public class Student extends People {
	public int studentNo;
	
	
	public Student(String name, String ssn, int studentNo) {
		
		//super(name,ssn);
		// 부모 생성자 호출
		this.studentNo = studentNo;
	}
}


// super(...)
// 명시적인 부모 생성자 호출
// 부모 객체 생성할 때, 부모 생성자 선택해 호출
// super(매개값.)
// 매개값과 동일한 타입, 개수, 순서 맞는 부모 생성자 호출


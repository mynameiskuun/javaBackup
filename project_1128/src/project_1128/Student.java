package project_1128;

public class Student {

	String name;
	String address;
	String hakbun;
	int kor;
	int eng;
	int math;
		
	Student() {
		
	}
		
	Student(String name, String hakbun, String address) {
		this.name = name;
		this.hakbun = hakbun;
		this.address = address;
	}
	Student(int kor, int eng, int math){
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	Student(String name,String address,String hakbun,int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
		this.hakbun = hakbun;
		this.address = address;
	}
		
	int sum() {
		return this.kor+this.eng+this.math;
		
	}
	double avg() {
		return sum()/3.0;
		// 3을 3.0으로 하던지. sum() 앞에 (double)를 붙여줘서 소숫점 이하가 사라지지 않도록 하기
		
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", hakbun=" + hakbun + ", kor=" + kor + ", eng=" + eng
				+ ", math=" + math + "]";
	}





	
		
}

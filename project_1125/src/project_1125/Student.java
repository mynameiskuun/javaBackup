package project_1125;

public class Student {
	String name;
	String address;
	String hakbun;
	int kor;
	int math;
	int eng;

	public Student(String name, String hakbun, String address) {
		this.name = name;
		this.hakbun = hakbun;
		this.address = address;
	}

	public Student(String name, String hakbun, String address, int kor, int math, int eng) {
		this.name = name;
		this.hakbun = hakbun;
		this.address = address;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	double avg() {
		double result = sum() / 3;
		return result;
		// == return sum() /3;
	}

	void printAvg() {
		System.out.println(sum()/3);
	}
	void printSum() {
		System.out.println(sum());
	}
	int sum() {
		return this.kor + this.math + this.eng;

	}
}

package project_1202;

public class People {
	public String name;
	public String ssn;
	
	People() {}
	public People(String name) {
		this.name = name;
	}
	
	public People(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
}
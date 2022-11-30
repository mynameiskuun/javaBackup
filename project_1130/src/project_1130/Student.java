package project_1130;

public class Student {
	String name;
	String hakbun;
	Scores scores;

	public void updateScore(int kor, int eng, int math) {
		scores.setKor(kor);
		scores.setEng(eng);
		scores.setMath(math);
	}

	String getNameHakbun() {
		return name + hakbun + "의 ";
	}

	void printNameHakbun() {
		System.out.print(getNameHakbun());

	}

	public Scores getScores() {
		return scores;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
	}

	public Student(String name, String hakbun) {
		super();
		this.name = name;
		this.hakbun = hakbun;
	}

	public Student(String name, String hakbun, Scores scores) {
		super();
		this.name = name;
		this.hakbun = hakbun;
		this.scores = scores;
	}

//	@Override
//	public String toString() {
//		return "Student [name=" + name + ", hakbun=" + hakbun + ", scores=" + scores + "]";
//	}
//	
}

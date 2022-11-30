package project_1130;

public class Scores {
	private int kor;
	private int math;
	private int eng;

	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		if (kor >= 0) {
			this.kor = kor;
		}
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		if (math >= 0) {
			this.math = math;
		}
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		if (eng >= 0) {
			this.eng = eng;
		}
	}

	int sum() {
		return kor + math + eng;
	}

	void updateScore(int kor, int math, int eng) {
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	void printSum() {
		System.out.println("총점: " + sum());
	}

	public Scores(int kor, int math, int eng) {
		super();
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

//	@Override
//	public String toString() {
//		return "Scores [kor=" + kor + ", math=" + math + ", eng=" + eng + "]";
//	}
//	
}

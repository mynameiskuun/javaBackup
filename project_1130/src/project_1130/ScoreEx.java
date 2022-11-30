package project_1130;

public class ScoreEx {

	public static void main(String[] args) {

		Student stu = new Student("손흥민","01");
		Scores sco = new Scores(89,91,80);
//		stu.scores = sco;
//		stu.setScores(sco);
		
		sco.printSum();
		
		stu.setScores(new Scores(89,91,88));
//		System.out.println(stu);
		stu.printNameHakbun();
		stu.scores.printSum();
		stu.updateScore(80, 20, 30);
		stu.scores.printSum();
		stu.updateScore(10, 10, 10);
		stu.scores.printSum();
		stu.updateScore(82, -1,80);
		stu.scores.printSum();
	}
}

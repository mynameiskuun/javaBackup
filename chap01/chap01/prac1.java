package chap01;

public class prac1 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 4 == 0) {
				sum += i;
			} else if (i == 100) {
				System.out.println(sum);
			}
		}
	}

}

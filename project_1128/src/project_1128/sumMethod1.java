package project_1128;

public class sumMethod1 {

	int exportMethod() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		return 0;
	}

	int sumMethod() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		return sum;
	}
	
	int nSumMethod(int a) {
		int sum = 0;
		for(int i=1; i<=a; i++) {
			sum += i;
		}
		return sum;
	}
	
	double divMethod(int a, int b) {
		double result = a / b;
		return result;
	}
	
	String changeMethod(String a) {
			String result = "";
			for (int i=0; i<a.length(); i++) {
				char ch = a.charAt(i);
				
				if('a'<=ch && ch<= 'z') {
					result += (char)(ch-32);
				} else {
					result += ch;
				}
			}
			return result;
	}
}



















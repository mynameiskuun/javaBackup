package project_1201;

public class MethodEx {

	double areaRectangle(double width) {
		return width * width;
	}
	
	double areaRectangle(double width, double height) {
		return width * height;
	}
	
	public static void main(String[] args) {
		MethodEx myCalcu = new MethodEx();
		
		double result1 = myCalcu.areaRectangle(10);
		double result2 = myCalcu.areaRectangle(20,30);
		
		System.out.println("result1 :" + result1);
		System.out.println("result2 :" + result2);
	}

}

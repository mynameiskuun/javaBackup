package project_1202;

public class ChildEx {
	public static void main(String[] args) {
		
		Parents pa = new Child();

		// 자식 객체가 부모의 데이터 타입으로
		// Parents 클래스 및 데이터 타입 pa가 자식 객체 Child의 데이터 타입으로
//		Child ch = new Parents(); 안됨

		pa.m1();
		pa.m2();
	}
}

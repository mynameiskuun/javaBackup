package Parent;

public class ChildExample {
	public static void main(String[] args) {
		Parent p2 = new Parent();
		
		boolean result = p2 instanceof Child;
		if(result) {
			Child c2 = (Child) p2;
			System.out.println("됩니다");
		} else {
			System.out.println("안됩니다");
		}
		
		Parent parent = new Child();
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		/*
		 parent.field2 = "data2";	불가능
		 parent.method3();			불가능
		 */
		
		
		Child child = (Child) parent;
		child.field2 = "yyy"; //가능
		child.method3(); //가능
	}
}

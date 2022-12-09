package project_1209;

public class Parent {
	
	void parentMethod() {
		
	}
	class Child extends Parent { }
	class A {
		Parent field = new Parent() {
			
		};
		
		void method1 (Parent parent) {}
		void method2 () {
			method1(new Parent() {
				
			});
		}
		
		
		void method() {
			Parent localVar = new Child();
		}
	}
}

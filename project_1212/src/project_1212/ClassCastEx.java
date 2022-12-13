package project_1212;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class ClassCastEx {
	
	public static void changeDog(Animal animal) {
		if (animal instanceof Dog) {
			Dog dog = (Dog) animal;
			System.out.println("변환됩니다");
		} else {
			System.out.println("변환 안됩니다");
		}
	}
	
	public static void main(String[] args) {
		Animal ani = new Dog();
		Animal ani2 = new Animal();
//		Dog dog = (Dog) ani;
		
		Dog dog;
		Cat cat = (Cat) ani;
		Dog dog2 = (Dog) ani2;
		
		
		
		
	}

}


public class PrinterExample {

	public static void main(String[] args) {

//		Printer printer = new Printer();
//		printer.println(10);
//		printer.println(true);
//		printer.println(5.7);
//		printer.println("홍길동");
		
		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");
	}

}

1. 다형성
2. 오버라이딩
3. 오버로드
4. 예외처리
5. 예외 떠넘기기
6. jdbc 연동
7. static
8. 상속
9. toString
10. compareTo

11. getteer, setter 사용하는 이유
데이터를 보호하기 위함.
데이터를 불러올 때, 한번 더 가공하는 과정을 거침으로서(setter 안에 if문 작성), 내부 데이터가 결함을 가지지 않도록 하는것.(무결성)
하지만 무분별한 Setter는 데이터 무결성을 해칠 수 있음.
이를 해결하기 위해, 객체를 생성하는 생성자와, 이를 표현하는 메소드를 분리하여 사용하는 Builder 패턴을 이용해서 조금 더 직관적인 코드를 작성할 수 있다.
12. 깃 사용법

git init
git add .
git commit -m "작성문구"
git remote add origin https://github.com/mynameiskuun/리파지터리 이름
git push origin master

package project_1212;

public class errorEx {

	public static void main(String[] args) {
		String data = "null";
		System.out.println(data.toString());
		
		if (args.length == 1) {
			String data1 = args[0];
			System.out.println(data1);
		} else {
			System.out.println("arg[0]에 값 없음");
		}
		
		String arr[] = {"가","나","다"};
		int num = 2;
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

// 에러
// 하드웨어의 잘못된 동작 또는 고장으로 인한 오류
// 에러가 발생되면 프로그램 종료
// 정상 실행 상태로 돌아갈 수 없음


// 예외
// 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인한 오류
// 예외가 발생되면 프로그램 종료
// 예외처리 추가하면 정상 실행 상태로 돌아갈 수 있음.
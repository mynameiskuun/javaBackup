package project_1128;
	
public class Students {
	
	Student[] stuArr;

	// Student stuArr과 ?
	void init() {
		for(int i=0; i<stuArr.length; i++) {
			insertStudent(i,"홍"+i,"마포구","0"+(i+1),12+i,80+i,72+i);
		}
	}
	// 리턴값이 필요하지 않음. init() 메소드는 return값이 필요한게 아니라, 해당 배열에 학생들을 채워넣는 기능만 하기 때문.
	void insertStudent(int i,String name, String address, String hakbun, int kor, int eng, int math) {
		stuArr[i] = new Student(name,address,hakbun,kor,eng,math);
	}	
	//void 리턴값 없을때 혹은 리턴값이 필요없을때 적용시킴
	
	
	
	
	Student searchStudent(String hakbun) {
		for(int i=0; i<stuArr.length; i++) {
			if(stuArr[i].hakbun.equals(hakbun)) {
//				System.out.println(stuArr[i]);
				return stuArr[i];
			}
		}
		return null;
	}
	// 이 경우엔 return stuArr[i]가 꼭 필요함. 메소드의 이름인 searchStudent에서도 그렇듯, 배열 안에서 조건에 맞는 특정한 학생을 찾아서 꺼내는 역할이기 때문.
	
	
	void updateScore(String hakbun, int kor, int math, int eng) {
		Student student = searchStudent(hakbun);
		
		if(math >= 0) {
			student.kor = kor;
		}
		if(math >= 0) {
			student.math = math;
		}
		if(math >= 0) {
			student.eng = eng;
		}
	}
}

package project_1214;
		
import java.util.ArrayList;
import java.util.List;
		
public class ListEx extends Object{
		
	public static void main(String[] args) {
		List<String> list2 = new ArrayList<String>();
		//제네릭이 가장 많이 쓰이는 부분
		list2.add("33");
		System.out.println(list2.get(0));
		
		ArrayList list = new ArrayList();
		list.add("Hello");
		String str = (String) list.get(0);
		Object obj = list.get(0);
		
		System.out.println(str);
	}

}

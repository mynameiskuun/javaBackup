package project_1214;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("자바");
		list.add("JDBC");
		list.add("MySQL");
		
		for(String str : list) {
			System.out.println(str);
		}
		list.size();
		System.out.println(list.size());
		// length와 같음
		
	}

}

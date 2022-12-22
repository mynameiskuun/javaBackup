package project_1222;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuncApiEx {

	public static void main(String[] args) {

		//--------------------------------------------------
		Consumer<Integer> co = (t)->{
			System.out.println(t);
		};
		
		co.accept(123);
		//--------------------------------------------------
		Supplier<String> sp = ()-> {
			return "test";
		};
		System.out.println(sp.get());
//		sp.get();
		
		//--------------------------------------------------
		Function<String,Integer> f = (x) -> {
			return Integer.parseInt(x);      
		};
		System.out.println(f.apply("200"));
		
		//--------------------------------------------------
		IntBinaryOperator op = (x, y) -> {
			return x;
		};
		System.out.println(op.applyAsInt(0, 0));

		//--------------------------------------------------
		Predicate<String> pr = q -> {
			return q.equals("test");
		};
		System.out.println(pr.test("test"));
		//--------------------------------------------------
	}
}

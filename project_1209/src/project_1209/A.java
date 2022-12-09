package project_1209;

public class A {

	void m() {
	}

	class c {

		void mc3() {
			A aa2 = new A();
		}
		A a = new A() {
			@Override
			void m() {
				super.m();
			}

		};

		void mc1(A a) {}
		void mc2() {
			A aa = new A();
			mc1(new A() {

				@Override
				void m() {
					super.m();
				}

			});
		}
	}
}

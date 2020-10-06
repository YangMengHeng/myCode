class Outer {
	private int data[];
	Outer(int x[]) {
		data = x;
	}
	void checkInner() {
		Inner innerObj = new Inner();
		innerObj.show(); // 调用Inner对象的show（）方法
		System.out.println("内部类计算的平均值: " + innerObj.average());
	}
	void checkLocal() {
		class Local {
			void show() {
				System.out.print("从局部类显示数组元素:");
				for (int i = 0; i < data.length; i++) {
					System.out.print(data[i] + " ");
				}
				System.out.println();
			}
			int average() {
				int sum = 0;
				for (int i = 1; i < data.length; i++) {
					sum += data[i];
				}
				return sum / data.length; // 返回data数组的平均值
			}
		}
		Local localObj = new Local();
		localObj.show();
		System.out.println("局部类计算的平均值: " + localObj.average());
	}

	class Inner {
		void show() {
			System.out.print("从内部类显示数组元素:");
			for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]; // 打印data数组的每个元素
                System.out.print(' ');
			}
			System.out.println();
		}
		int average() {
			int sum = 0;
			for (int i = 1; i < data.length; i++) {
				sum += data[i];
			}
			return sum / data.length;
		}
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		int a[] = { 6, 8, 9, 22, 34, 7, 2, 1, 15 };
		Outer outerObj = new Outer(a);
		outerObj.checkInner();
		outerObj.checkLocal(); // 调用outerObj对象的checkLocal方法
	}
}

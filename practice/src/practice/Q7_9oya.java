package practice;

//abstractがついているので抽象クラスであることを指す
abstract class Q7_9oya {
	
	public void sample() {
		System.out.print("A");
		test();
		System.out.print("C");
		System.out.println();
	}
	
	//抽象クラスであるが所以の抽象メソッド
	protected abstract void test();

}

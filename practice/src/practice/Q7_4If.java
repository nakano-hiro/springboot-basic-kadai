package practice;

public interface Q7_4If {
	
	//インターフェースでは、抽象メソッドを記述する
	//抽象メソッド・・・中身がないメソッド。実装先(implements)、あるいは継承先(extends)で中身を決める必要がある。
	//中身を持たせると決めなくてもよくなる
	
	//抽象メソッド基本
	//void メソッド名();
	
	
	//中身を持たせたい場合は、defaultで修飾すると可能
	default void sample7_4() {
		System.out.println("7_4");	}

}

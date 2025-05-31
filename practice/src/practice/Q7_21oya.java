package practice;

public class Q7_21oya {
	
	//this(); = コンストラクタでしかつかえない特殊な構文。
	//コンストラクタの呼び出しに使う。()に引数を入れて、引数ありのコンストラクタを指定もできる。
	//なお、コンストラクタ内の1行目に記述しないとだめ。
	
	public Q7_21oya() {
		System.out.print("21oya ");
	}
	
	public Q7_21oya(String val) {
		this();
		System.out.print(val);
	}

}

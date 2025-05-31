package practice;

public class Q7_21Sub extends Q7_21oya {
	
	//this(); = コンストラクタでしかつかえない特殊な構文。
	//コンストラクタの呼び出しに使う。()に引数を入れて、引数ありのコンストラクタを指定もできる。
	//なお、コンストラクタ内の1行目に記述しないとだめ。
	
	public Q7_21Sub() {
		super("21sub1 ");
		System.out.print("21sub2 ");
	}
	
	public Q7_21Sub(String val) {
		this();
		System.out.print(val);
	}

}

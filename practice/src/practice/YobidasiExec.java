package practice;

public class YobidasiExec {

	public static void main(String[] args) {

		//フィールド、メソッド、クラスの呼び出し方について
		
		//クラスの呼び出し（インスタンス化）
		//クラス名とオブジェクト名を決めて、newで呼び出すのが特徴
		Yobidasi y = new Yobidasi();
		
		//フィールドの呼び出し
		//オブジェクト名.フィールド名
		System.out.println(y.message);
		
		//メソッドの呼び出し
		//オブジェクト名.メソッド名
		//メソッドには（）がついているので、（）がついているのが特徴
		y.say();
		
		
		//【static】
		//以下のように、クラスから直接呼び出すことが可能。
		
		//クラス名.フィールド名
		System.out.println(Yobidasi.greeting);
		//クラス名.メソッド名
		Yobidasi.shout();

	}

}

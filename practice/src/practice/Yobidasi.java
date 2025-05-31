package practice;

public class Yobidasi {
	
	String message = "Hi"; //フィールド
	static String greeting = "Hello"; //staticフィールド
	
	//メソッド
	//void intなど、戻り値を定義するとメソッドと判断される。
	//voidは何も返さないのになぜ必要か⇒メソッド（何を返すかの定義が必要）として分類するために必要
	void say() {
		System.out.println(message);
	}
	
	//staticメソッド
	static void shout() {
		System.out.println(greeting);
	}
	
	//コンストラクタ
	//メソッド名を使う。戻り値を定義することでメソッド判定となるので注意
	//インスタンス時にこれを使って初期値を決める（初期化をする）
	Yobidasi(){
		System.out.println("これはコンストラクタです");
	}

}

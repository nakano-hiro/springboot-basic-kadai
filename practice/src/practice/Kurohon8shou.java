package practice;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Kurohon8shou {

	public static void main(String[] args) {

		//ラムダ式・・・簡単に短くできる仕組み
		//関数型インターフェース・・・ラムダ式を使うための特別なインターフェース。
		//                            基本は値を受け取って値を返すようなものが多い。

		//基本の構文↓
		//関数型インターフェース 変数名 = (引数) -> { 処理 };
		
		//省略ルール
	    //（引数）の中は、データ型の記述はあってもなくてもOKだが、記述するかどうかはそろえる必要あり
		// return や波かっこ省略可能（1行の場合）
		// 引数が1つなら () も省略可（引数なしの場合は () が必要）

		
		//BiFunction<引数１, 引数２, 戻り値> = 2つの値を受け取り1つの値を返す
		BiFunction<Integer, Integer, Integer> Q1 = (Integer a, Integer b) -> {
			return a + b;
		};
		//変数名.apply();で実行する
		System.out.println(Q1.apply(5, 7));

		
		//Consumer<T> = 引数を1つ受け取って、何か処理を行い、戻り値がない
		Consumer<String> printConsumer = s -> System.out.println("受け取った文字列: " + s);
		// Consumerの処理を呼び出す
		printConsumer.accept("Hello, Consumer!");
		printConsumer.accept("Java ラムダ式");

		
		//Supplier<T> = 引数を持たずに値を返す
		Supplier<String> stringSupplier = () -> "Hello, Supplier!";
		// Supplierのget()メソッドを呼び出して値を取得
		String result = stringSupplier.get();
		System.out.println(result);

		
		//Predicate<T> = 1つの引数を受け取って true または false を返す
		Predicate<String> isNotEmpty = s -> !s.isEmpty();
		// チェック処理
        System.out.println(isNotEmpty.test("Hello")); // true
        System.out.println(isNotEmpty.test(""));      // false
		
		
		
		//関数型インターフェースを自分で定義した場合
		//抽象メソッドが一つだけ。
		Q8_1if Q8_1greet = (String name) -> {
			System.out.println("hello," + name);
		};
		Q8_1greet.greet("Q8_1");

		//サービスクラスを作って動作させてみた場合
		//インスタンス化
		Q8_1Service Q8_1s = new Q8_1Service();
		//セッターでラムダ式の処理をセット
		Q8_1s.setLogic(Q8_1greet);
		//doProcessメソッドの実行
		Q8_1s.doProcess("Lamda");
		
		
		
		
		

		//スコープの範囲について
		//ラムダ式を宣言しているブロック（ここではメインメソッド）で宣言した、
		//ローカル変数と同じ変数名はかぶるので宣言不可（ここではval8_3）
		String val8_3 = "A";

		Q8_3if Q8_3 = (val8_3_2) -> {
			System.out.println(val8_3);
			System.out.println(val8_3_2);
		};

		//val8_3 はメソッドの外で一度だけ "A" と代入された値で、どの呼び出しでも変わらない。
		//val8_3_2 は test8_3() を呼び出すときに渡した引数で、その都度変わる。
		Q8_3.test8_3(val8_3);//A,A
		Q8_3.test8_3("B"); //A,B

	}

	//8_3テストメソッド
	interface Q8_3if {
		void test8_3(String val);
	}
}

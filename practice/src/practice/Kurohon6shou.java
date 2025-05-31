package practice;

public class Kurohon6shou {

	public static void main(String[] args) {
		
		//ガベージコレクションについて
		//ガベージコレクション = 不要になったデータを削除する仕組み。
		//以下の15行目でガベージコレクションの対象になる処理は12行目、のように考える。
		//14行目のa4も対象だが、都度発生するので14と15が同時ではなく、順番に行われることを覚えておく
		Object a4 = new Object();
		Object b4 = new Object();
		Object c4 = a4;
		a4 = null;
		b4 = null;
		
		
		// static変数は「クラスで1種類につき1つだけ」共有されるため、
		// インスタンスをいくつ生成しても、そのstatic変数は共通。
		// どのインスタンスから変更しても、全体に反映される。

		Sample6_5.num5 = 10;          // static変数に10を設定（すべてのインスタンスで共有）
		Sample6_5 a5 = new Sample6_5(); // num5は共有なので10
		Sample6_5 b5 = new Sample6_5(); // こちらも同じくnum5は10
		a5.num5 += 10;                // num5 = 20（a5から操作しても、全体に影響）
		b5.num5 = 30;                 // num5 = 30（b5から変更しても、全体に影響）
		System.out.println(Sample6_5.num5); // 結果：30
		
		
		// Sample6_12 クラスにある devide メソッドは、引数に int を受け取り、戻り値に float を返す。
		// そのため、メソッドを呼び出して得られる値は float 型であり、
		// これを受け取る変数 result12 は float または double にする必要がある。
		// 今回は double 型で受け取っているが、float → double は自動的に型変換されるため問題ない。
		// 引数が int 型である点に惑わされず、メソッドの戻り値の型に注目することが大切。
		
		Sample6_12 s12 = new Sample6_12();
		double result12 = 	s12.devide(10, 2);
		System.out.println(result12);
		
		
		//以下は可変長変数を引数にした場合の呼び出し。ルールは以下。
		//①...を使えるのは１つのメソッドにつき１つまで。
		//②引数の最後にしなければならない。
		//...は、データ型の後ろに記述する。
		method14("値",1,2,3);
		
		
		
		//以下はオーバーロードした値を出力しようとしているが、
		//どちらのメソッドを使えばいいかわからないので、あいまいな処理としてコンパイルエラーが発生している。
		Kurohon6shou k17 = new Kurohon6shou();
		//System.out.println(k17.calc17(2,3));
		
		
		
		//以下は、6_21クラスにある初期化子により表示内容Bが優先されていることがポイント。
		//初期化子はコンストラクタが実行される前にされるのでB⇒C⇒Aの順になっている
		Sample6_21 s21 = new Sample6_21();
		
		
		
		System.out.println(Sample6_22.num);
		Sample6_22 s22 = new Sample6_22();
		System.out.println(s22.num);
		
		
		
		//thisの使い方についての設問。
		//thisでオーバーロードされた別のコンストラクタを呼び出していることで、
		//okが表示されるようになっている
		Sample6_24 s24 = new Sample6_24();
		
		
		
		//以下は設問29より、渡される値の違いに関する問題。
		//modifyメソッドで掛け算しているので20になってはいるが、
		//受け取っている変数はint numなので、10という値だけ受け取っている。
		//そのため、s29.numオブジェクト自体は変更されず、出力として10になっている。
		//※【重要】
		//intなどのプリミティブ型（基本データ型）String（特別）は値渡しされる
		//modifyメソッドに渡す値を参照型(Sample6_29 s29)のようにすると、s29自体の値を変更できる
		
		 Sample6_29 s29 = new Sample6_29(10);
	        int result29 = modify(s29.num);  // ← 変更点：戻り値を受け取る
	        System.out.println(result29);  // ← 20 が出力される
	        System.out.println(s29.num);   // ← 10 のまま
	        
	        
	        

	}
		
	
	//設問１４のテストメソッド
	static void method14(String label, int... num) {
		System.out.print(label + ":");
		for (int n : num) {
			System.out.print(n + "");
			System.out.println();
		}
		
	}
	
	private double calc17(double a, int b) {
	    return (a + b) / 2;
	}

	private double calc17(int a, double b) {
	    return (a + b) / 2;
	}
	
	
	//設問29のテストメソッド
	private static int modify(int num) {
	    num *= 2;  // num = num * 2 → 20 になるが…
	    return num;
	}



}

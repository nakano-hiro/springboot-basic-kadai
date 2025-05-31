package practice;

public class Kurohon3shou {

	public static void main(String[] args) {
		
		//〇 += ● は、〇 = 〇 + ● のこと。
		int a = 3;
		int b = a += 5;
		System.out.println(a + b);
		
		//-演算子は、文字(オブジェクト)にも適用される
		int num = -10;
		System.out.println(10 * -num);
		
		//++ -- インクリメントは1を足し引きする。
		//オブジェクトの前か後かで加減されるタイミングが変わる。
		int a4 = 10;
		int b4 = a4++ + a4 + a4-- - a4-- + ++a4;
		//  b4 = 10   + 11 + 11   - 10   + 10;
		System.out.println(b4);
		
		
        //以下は真偽値を比較するので、==か!=しか使えない
		//boolean a5= true;
        //boolean b5 = true;
		//System.out.println(a5 <= b5);
		
		
		
		Sample8 s1 = new Sample8(10);// インスタンス作成（仮にID：Aとする）
		Sample8 s2 = s1;// ID：Aのインスタンスを代入しているので、ID：Aである
		s1 = new Sample8(10);// 新たなインスタンスを作成して代入しているので、ID：Bである
		System.out.println(s1 == s2);// 値は同じでもインスタンスＩＤが違うのでfalseとなる
		
		
		//Sample9クラスにて、numだけ同じかをequalsメソッドで確認しているので、
		//以下の例ではnameが違っていてもtrueが返される
		Sample9 a9 = new Sample9(10, "a");
		Sample9 b9 = new Sample9(10, "b");
		System.out.println(a9.equals(b9)); // → Sample9.equals(Object obj) のオーバーライドが呼ばれる
		
		
		//Objectクラスを用いてインスタンスしている？
		//Sample10クラスでのequalメソッドでは、引数をSample10にしているためオーバーライドではなくオーバーロード。
		//そのため比較するためのequalメソッドが中身の比較をせずインスタンスIDの比較を行っているためfalseとなっている。
		Object a10 = new Sample10(10);
		Object b10 = new Sample10(10);
		System.out.println(a10.equals(b10));
		
		//equalsメソッドは、nullの場合はfalseを返すルール
		Object a11 = new Object();
		Object b11 = null;
		System.out.println(a11.equals(b11));

		//==は「インスタンスの比較」なのでfalseのはずだが、
		//文字列リテラルの場合は同じ参照（intern）を使うのでtrueとなる（特別？）
		String a12 = "Sample";
		String b12 = "Sample";
		System.out.print(a12 == b12);
		System.out.print(",");
		System.out.println(a12.equals(b12));
		
		
		
		//intern = 文字列リテラルと同じ内容の文字列があれば、それと同じ文字列を返すメソッド
		//以下の例の場合、
		//String専用のメモリ（プールと呼ぶ）に"abc"が登録される
		//⇒internメソッドで、プール内に同じ文字列"abc"があることを確認し、同じであると判断する
		
		//※【補足】newで新しくインスタンスを作成するが、これはヒープと呼ばれるメモリ領域に保存される（Stringに限らない）
		//このヒープと呼ばれる場所に保存されるのと同時に、プールに文字列も登録される。
		//プール内の文字列は使いまわしができるので、同じ文字列は重複しないが同じ文字列として認識・使用可能
		
		String a14 = "abc";
		String b14 = new String(a14);
		
			int count = 0;
			if (a14.intern() == "abc") { // プール内での比較なので同じと判断
				count++;
			}
			if (b14.intern() == "abc") { // 同上
				count++;
			}
			if (a14.intern() == b14.intern()) { // プール内での比較なので同じ判断
				count++;
			}
			System.out.println(count); // 結果３が表示される
			
		
		//if文で、{}を省略することができる。
		//ただし、ifの次の処理が優先（Aの処理）が行われる。
		//ただ、以下の場合はif(false)により、常に条件がfalseのため行われず、Bはif文のブロック外判定のため実施される状況。
		//※【補足】このように、if文がどこまでなのかわかりづらいので、{}の省略はしないこと
		if(false)
			System.out.println("A16");
		    System.out.println("B16");
		    
		
		//if文では、処理が合致した段階で処理が終わるので、Dは表示されない。
		//※改行されていて見づらくなっているので試験では要注意
		int num18 = 10;
		if(num18 == 100) {
			System.out.println("A");
		}else if(10 < num18) {
			System.out.println("B");
		}else if(num18 == 10){
			System.out.println("C");
		}else if(num18 == 10){
			System.out.println("D");
		}
		
		
		
		//以下はコンパイルエラーがでる行を確認する問題。
		//switch文は、定数じゃないとcaseとして認められないので気を付ける
		
		final int NUM20 = 0;
		int num20 = 10;
		
		switch(num20) {
//		case "10" -> System.out.println("A"); // int型なのに文字列にしているのでエラー
//		case num -> System.out.println("B");  // 変数は指定できないのでエラー（定数じゃないとだめ）
		case 2 * 5 -> System.out.println("C");
		case NUM20 -> System.out.println("D");
		default -> System.out.println("E");
		}
			
		
		//以下は以前のswitch文の書き方で注意しなければならないところ。
		//break;が入るまでは条件に合致していなくても処理が続くので、結果としてABCが表示される
		int num21 = 1;
		
		switch(num21) {
		case 1:
		case 2:
		case 3: System.out.print("A");
		case 4: System.out.print("B");
		default : System.out.print("C");
		}
	


	}

}

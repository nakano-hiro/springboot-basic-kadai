package practice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kurohon9shou {

	public static void main(String[] args) {
		
		//配列をリストに変換し、listにリストを代入している
		//イメージは、list = [1, 2, 3]
		List<Integer> list = Arrays.asList(new Integer[] {1, 2, 3});
		
		//変数名.sort() = リストを並べ替えるメソッド
		//(a, b) -> a.compareTo(b) = ラムダ式。
		//a.compareTo()は、aとbを比較して、下記を返す
		//a < b : 負の値
		//a = b : 0
		//a > b : 正の値
		//今回の例だと、[1, 2, 3]を順番に比較している
		//① a = 1, b = 2  :負の値 = aをbの前に置く
		//② a = 2, b = 3  :負の値 = aをbの前に置く
		//③ a = 3, b = 1  :正の値 = bをaの前に置く
		list.sort((a, b) -> a.compareTo(b));
		//※【応用】a.compareTo(b)の先頭に、-を付けると逆順になる

		for(Integer num : list) {
			System.out.print(num);
		}
		System.out.println();
		
		
		//Characterクラスに関する設問
		//charのラッパークラス
		char a4 = '0';
		int num4 = 0;
		
		//引数がアルファベットか
		if (Character.isAlphabetic(a4)) {
			num4++;
		}
		//引数が数字か
		if (Character.isDigit(a4)) {
			num4++;
		}
		//引数が小文字か
		if (Character.isLowerCase(a4)) {
			num4++;
		}
		System.out.println(num4);
		
		
		//日付のAPI
		//.of = 指定した日付でのインスタンス作成
		LocalDate a5 = LocalDate.of(2015, 1, 1);
		//.parse = 文字列の日付をLocalDateクラスに変換しインスタンス作成
		LocalDate b5 = LocalDate.parse("2015-01-01");
		//.now = 現在時刻でインスタンス作成
		LocalDate c5 = LocalDate.now();
		System.out.println(c5);
		System.out.println(a5.equals(b5));
		
		//その日付週の曜日に合わせたへ付けへ変更。
		//LocalDateは不変なので、新しいインスタンスが必要
		LocalDate d5 = a5.with(DayOfWeek.SUNDAY);
		System.out.println(d5);
		System.out.println(a5.equals(b5) + "," +  d5.isAfter(b5));
		
		
		//データ型(ジェネリクス)を指定してないリストについて
		//以下のように、無でも可能だが、安全性のため基本は指定する
		//型指定例⇒ArrayList<String> Q8 = new ArrayList<>();
		ArrayList Q8 = new ArrayList<>();// ArrayList<Object> Q8 = new ArrayList<>(); と同義
		Q8.add("A");
		Q8.add(10);
		Q8.add('B');
		for (Object obj : Q8) {
			System.out.println(obj);
		}
		
		//追加の場所とエラー
		ArrayList<String> Q9 = new ArrayList<>();
		try {
		Q9.add("A");
		Q9.add("B");
		Q9.add(3,"C");//3番目に"C"を追加するの意味
		Q9.add("D");
		for (String str : Q9) {
			System.out.print(str);
		}
		}catch(Exception e) {
			System.out.println("IndexOutOfBoundsExceptionエラー = インデックス番号が範囲外");
			System.out.println("Cを追加しようとしている段階で、3番目が無いことが原因");
			System.out.println("配列番号と値のイメージ図。Bを追加した段階では次の配列番号は2になるが、3のように飛ばせない");
			// 値の行を表示
            System.out.print("|");
            for (String val : Q9) {
                System.out.print(" " + val + " |");
            }
            System.out.println();

            // インデックスの行を表示
            for (int i = 0; i < Q9.size(); i++) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
        System.out.println(); // 改行
		
		
        //set,add,remove
        ArrayList<String> Q10 = new ArrayList<>();
		Q10.add("A");
		Q10.add("B");
		Q10.set(0,"C");//set = 置き換え
		Q10.add(1,"D");//add = その配列番号に追加
		Q10.add("A");
		Q10.add("D");
		Q10.remove("D");//remove = 条件に合致する最初の値を削除。この場合は119行目のDを削除している
		for (String str : Q10) {
			System.out.print(str);
		}
		System.out.println();
		
		
		//removeされたときの値の場所について
		//繰り返し処理中に削除されるとひとつ前に繰り上がるので、、
		//その番の処理が終わり、繰り上がったCの処理は終了したこととなる
		ArrayList<String> Q12 = new ArrayList<>();
		Q12.add("A");
		Q12.add("B");
		Q12.add("C");
//		Q12.add("D");
//		Q12.add("E");
		for (String str : Q12) {
		  if("B".equals(str)) {
			Q12.remove(str);
		}else {
			System.out.println(str);
		}
		}
//		Q12.removeIf(str -> "B".equals(str));
//		for (String str : Q12) {
//			System.out.println(str);
//		}
		
		//繰り返し処理＋繰り返し処理によるエラー
		try {
	    for (String str : Q12) {
			System.out.print(str);
		}
		}catch(Exception e) {
			System.out.println("ConcurrentModificationExceptionエラー");
			System.out.println("繰り返し処理を行っている時に繰り返し処理で何かをしようとすると、同時処理エラーとして上記が発生");
			System.out.println("処理が短いと発生しないこともあるが、基本はこの書き方はNG");
	    }
		System.out.println();
		
		
		
		//mismatchメソッド = 配列の中を順番に比較して、違う場所を返す
		int[] arr1 = {1, 2, 3};
	    int[] arr2 = {1, 2, 3};
	    int[] arr3 = {2, 3};
	        System.out.println(Arrays.mismatch(arr1, arr2)); // → -1（すべて一致）
	        System.out.println(Arrays.mismatch(arr1, arr3)); // → 0（index 0 が違う）
		
	        
	    //compareメソッド = 配列の中身を左から順に比較し、String.compareTo() のルール（辞書順）に従って比較
	    //a < b → 負の値
	    //a == b → 0
	    //a > b → 正の値
	    //※要素の中身が同じの場合、残りの長さ数が戻り値として返ってくる。
	    String[] a16 = {"B", "F"};
	    String[] b16 = {"B", "A"};
	    String[] c16 = {"B", "P"};
	    String[] d16 = {"B", "F", "P","P"};
	    String[] e16 = {"B"};
	    System.out.println("Q16の解答1:"+ Arrays.compare(a16, b16));//Aから数えてFは5番目
		System.out.println("Q16の解答2:"+ Arrays.compare(a16, c16));//Pから数えてFは-10番目
		System.out.println("Q16の解答3:"+ Arrays.compare(a16, d16));//中身は同じだが長さが違う：a16はd16より2つ少ない=-2
		System.out.println("Q16の解答4:"+ Arrays.compare(d16, e16));//d16はe16より3つ多い=3
		
		
		
		//removeIf = コレクション（例えば ArrayList）にあるメソッドで、**「条件に合致する要素を一括で削除する」**
		//遠回しに言うと、trueのものを削除する
		List<String> Q17 = new ArrayList<>(
		Arrays.asList(new String[]{"A", "B", "C"}));
		
		Q17.removeIf(
				//このラムダ式の関数型インターフェースは、
				//sと"B"を比較してるだけなので、Predicate(boolean)と判断
				(String s) -> {return s.equals("B");}
				);
		System.out.println(Q17);
		
		
		//forEach = 簡単な繰り返し処理で使用
		//２つは書き方は違うが同じ意味
		List<String> Q18 = List.of("A", "B", "C");
		
		//ラムダ式
		Q18.forEach(str -> System.out.print(str));
		//メソッド参照（簡易ラムダ式）
		//メソッドが所属するクラス名(StringとかでもOK)またはインスタンス名::メソッド名
		Q18.forEach(System.out::print);
		System.out.println();
				
		
		
	}

}

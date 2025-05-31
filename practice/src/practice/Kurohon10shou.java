package practice;

public class Kurohon10shou {

	public static void main(String[] args) {
		
		//argsは基本0。javaコマンドなどで引数を渡してあると変わる
		try {
		if(args.length == 0) {
			System.out.println("A");
		}
		}catch (Exception e) {
			System.out.println("B");
		}finally {
			System.out.println("C");
		}
		

		System.out.println("Q5の解答");
		System.out.println(test5(null));
		
		
		int r7 = sample7();
		System.out.println("Q7解答。「返されるのはreturn時点の値」:" + r7);
		
		
		//2つのtry-catchブロックがネストされている場合
		try {
			try {
				String[] array9 = {"A", "B", "C"};
				System.out.println(array9[3]);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.print("D");
			}finally {
				System.out.print("E");
			}
		}catch (ArrayIndexOutOfBoundsException e) {//先に１つ目のcatchでエラー回収されているのでスルー
			System.out.print("F");
		}finally {
			System.out.print("G");
		}
		System.out.println();
		
		
		
		
	}
	
	//Q5のテストメソッド
	private static String test5(Object obj) {
		try {
			System.out.println(obj.toString());//toString() = 文字列にして返す※nullは例外。つまりエラー
		}catch (NullPointerException e) {
			return "A";
		}finally {
			System.out.println("B");//finallyはreturnの前に必ず実行される
		}
		return "C";
		
	}
	
	//Q7のテストメソッド
	private static int sample7() {
		int val = 0;
		try {
			String[] array = {"A", "B", "C"};
			System.out.println(array[3]);//例外発生でcatch節へ
		}catch (RuntimeException e){
			val = 10;
			System.out.println("catch内val:" + val);
			return val;//return値が一時的に保存される
		}finally {
			val += 10;//finally内で値変更されるが、returnはcatch節の中なので反映されない！
			System.out.println("finally内val:" + val);
//			return val; //ここでreturnすればfinallyの値が反映される
		}
		return val;
	}

}

package practice;

public class Kurohon2shou {

	public static void main(String[] args) {
		
//	System.out.println("Hello, Java from Eclipse!");
	
		
		
		 String huhen = "hoge, world.";
	        hello(huhen);  // hello メソッドを呼び出すが、結果を受け取っていない
	        System.out.println(huhen);  // str をそのまま表示
	    
		
		
		
		String str = "abcde";
		
		//charAt = 指定した番号の文字を探す
		//0スタートの4番目はe
		System.out.println(str.charAt(4));
		
		
		//indecOf = 最初の文字の出現位置を探す
		//以下例ではdの位置が0スタートの3番目なので3と表示
		System.out.println(str.indexOf("de"));
		
		
		//substring = 任意の範囲を切り取る
		//以下の場合は0スタートで2番目～4番目の手前までを切り取るのでcd
		System.out.println(str.substring(2,4));
		
		//replace = 置き換える
		System.out.println(str.replace("abcd", "bb"));
		
		
		//lengthは文字数を返すため、5を返す。
		//一方5を返されたcharAtは、0スタートで5番目の文字を探してもないため、
		//実行時に例外が発生する。	
		try{
			System.out.println(str.charAt(str.length()));
		}catch(Exception e) {
			System.out.println("例外発生(StringIndexOutOfBoundsException)");
		}
		
		//startsWith = 真偽値を返す（true or false）
		//以下は"b"から始まるかを問いているので、true
		System.out.println(str.substring(1,3).startsWith("b"));
		//【補足1】endWith = 終わりの文字を照合する
		System.out.println(str.substring(1,3).endsWith("d"));
		//【補足2】上記のように、複数のメソッドを組み合わせることをメソッドチェインと呼ぶ
		//以下別例:"bc"を抽出し、"b"⇒"c"に変換している
		String str2 = str.substring(1,3).replace("b", "c");
		System.out.println(str2);
		
		//concat = ＋演算子と同じ
		String greet = "hello,".concat("Java!");
		String greet2 = "hello,"  + "Java!";
		System.out.println(greet);
		System.out.println(greet2);
		
		//nullは文字列に置き換えられるので、出力はnullnull
		String str19 = null;
		str19 += "null";
		System.out.println(str19);
		
		//StringBuilderの初期容量値は「16」。
		//以下では5文字でコンストラクタしているので合計21が出力。
		StringBuilder sb = new StringBuilder("abcde");
		System.out.println(sb.capacity());
		
		//以下のは合いは、初期容量16に対して17文字を代入した場合。
		//その場合は自動拡張されるが、計算式は「新容量 = (旧容量 * 2) + 2」
		StringBuilder sb2 = new StringBuilder();
		sb2.append("12345678901234567");//17文字 ※appendについては次のコードで実践
		System.out.println(sb2.capacity());//自動拡張されている（34）
		
		//※append = 新しい文字列を追加する
		sb2.append("abc");
		System.out.println(sb2);
		
	}
	
	private static void hello(String msg) {
		//replaceAll = 指定した文字列を上書きできる
		//ただし、このメソッドの場合はString型であり不変のため、
		//変更はされるが代入されていないため反映されない。
        msg.replaceAll("hoge", "hello");  // 新しい文字列を作るが、返さない
        
        //反映したい場合はメソッドをString型に変更し、リターンする
        // return msg.replaceAll("hoge", "hello");
    }


}

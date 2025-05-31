package practice;

public class Kurohon4shou {

	public static void main(String[] args) {
		
		//while文にtrueなどを用いると無限ループに陥るため基本はNG。
		//※使う場合はreturnなどでループを抜ける処理を記述すれば大丈夫
		
		int a1 = 11;
		int b1 = 0;

		while (b1 < 5) {
			if (5 < a1) {
				System.out.print(b1);
			}
			a1--;
			b1++;
		}
		
		System.out.println();
		
		
		//do-while文の書き方。
		
		int a2 = 0;
		
		do {
			System.out.print(a2++);
		} while (a2 < 5);

		
		System.out.println();
		//スコープ。total変数はfor文の中で宣言されているので、{}外では使えないのでコンパイルエラー
		int a5 = 1;
		
		for(int b5 = 2, total = 0; b5 <= 5; b5++) {
			total = a5 * b5;
		}
//		System.out.println(total);
		
		
		//for文の中にある更新文は複数指定できる。
		//メソッド名も指定ができ、下記例ではperiodメソッドを更新時に呼び出している
		for (int i8 = 0; i8 < 3; i8++, period()) {
			System.out.print(i8);
		}
		
		System.out.println();
		
		
		//以下の例文は、合計が10で出力されるようにした二重ループのfor文。
		//多次元配列があるのでややこしい。
		int array9[][] = new int[][] {{1,2}, {2,3,4}};
		int total9 = 0;
		
		for(int i = 0; i < array9.length; i++) {
			for(int j = i; j < array9[i].length; j++) {
				total9 += array9[i][j];
			}
		}
		System.out.println(total9);
		
		//以下多次元配列の考え方。
		//困ったら以下のように図解する。
		int arrayREI[][] = new int[][] {{1,2}, {2,3,4}};
		
//		arrayREI[行][要素の番号]
		
//		array9 = {
//		          {1, 2},       // ← 行0（要素2つ）
//		          {2, 3, 4}     // ← 行1（要素3つ）
//		        }
//		問題コードに当てはめると、
//		最初のループは0行目の0番目の値なので、1となる。
//		最初のループの２回目（array9[i].length）は、0行目の1番目なのでさっきの1+今回の2=3となる。
//		次のループは1行目の１番目なので3。さっきの3と3を足して6。
	
		
		
		//continue = 処理をスキップする。
		//以下の設問では割り切れた場合はスキップになるので9になる。
		int[] array15 = {1,2,3,4,5};
		int total15 = 0;
		
		for(int i: array15) {
			if(i % 2 == 0)
				continue;
			    total15 += i;
		}
		System.out.println(total15);
		
		
		//以下はラベル・continue・breakを活用した足し算。
		//ラベル = 記載されている場所に処理を戻せるもの。（a: b:がそれ）
		//continue = その回だけ処理をスキップする
		//break = ループをやめる
		//解説すると、iが1と3のときだけ、jが1,2,3加算されるので12となる
		int total17 = 0;
		a: for(int i = 0; i < 5; i++) {
			b: for(int j = 0; j < 5; j++) {
				if(i % 2 == 0) continue a;
				if(3 < j) break b;
				total17 += j;
			}
		}
		System.out.println(total17);
		





	}
	
	//問題8のメソッド
	private static void period() {
		System.out.print(",");
	}

}

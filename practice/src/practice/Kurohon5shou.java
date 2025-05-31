package practice;

public class Kurohon5shou {

	public static void main(String[] args) {
		
		//以下の書き方は、int[] array = {}; と同じ。
		//空の配列が作成されていて、コンソールには謎のコードが表示される。
		//直接arrayを表示しているためハッシュコードが表示されてしまう。
		//中身を見るときは、System.out.println(Arrays.toString(array)); を使う
		int[] array = new int[0];
		System.out.println(array);
		
		
		//以下は、配列の宣言方法。
		//書き方としてはすべて正解。
		//次元については[]の数で決まる
		
		int[] a2;    //1次元配列
		int b2 [];   //1次元配列
		int[][] c2;  //2次元配列
		int d [][];  //2次元配列
		int[] e2[];  //2次元配列
		int[][] f2[];//3次元配列
		
		//※【補足】配列型変数の宣言を行う場合は、要素数はnewした時だけ指定できる。
		
		int [] a3 = new int[3];
		
		//以下はNG例。次元の数を決める意味で[]を書き、その後=で要素数や中身を書くイメージ
		//int [3] b3; ←NG
		
		
		//宣言の際、四則演算は可能だが、以下のようにもとの要素数が空なのに要素を入れられ無いので、コンパイルエラーになる
		int[][] e4 = new int[3][];
		// int f [][] = new int[][3]; ←NG 
		
		//nullを代入している
		String[] array6 = {"A","B","C","D","E"};
		array6[0] = null;
		for(String str : array6) {
			System.out.print(str);
		}
		System.out.println();
		
		
		//以下の拡張for文では、要素を一つずつ取り出して加算している。
		//int[]型とint型は違う。int[] = intにはならない。
		//なので、int val : tmpで取り出した要素をint val で取り出している
		int[][] arrayA10 = {{1,2},{1,2},{1,2,3}};
		int[][] arrayB10 = arrayA10.clone();
		int total10 = 0;
		
		for(int[] tmp : arrayB10) {
			for(int val : tmp) {
				total10 += val;
			}
		}
		System.out.println(total10);
		
	}

}

package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class test {
	
	private int numtest = 10;
	static int numstatic = 100;
	
	void test() {
		int i = 0;
		Supplier<Integer> foo = () -> i;
//		i++;
		System.out.println(foo.get());
	}
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("apple", "banana", "cherry");
		//forEachはコレクションに対して要素を一つずつ取得して処理する
		list.forEach(x -> System.out.println(x));
		
		
		int[] array = {0, 1};
		int[][][] array2  = new int[2][2][2];
		array2[0][0] = array;
		array2[0][1] = array;
		array2[1][0] = array;
		array2[1][1] = array;
		System.out.println(array2[0][1][0]);
		
		
//		for(;;) {
//		無限ループ！だが実行はできてしまう
//		}
		
		
		List<Character> list2 = List.of();
		try {
		list2.add('A');
		}catch(UnsupportedOperationException e) {
			System.out.println("例外：ofメソッドで作ったコレクションに変更は不可");
			
		int f = 12_34;
		System.out.println(f);
		}
		
		
		//中身の数が決まっていない。外側の箱の数を決めただけ
		String[][] array1 = new String[2][];
		
//		array1 (length = 2)
//		↓
//		+-----------+-----------+
//		| array1[0] | array1[1] |
//		|  (ref)    |  (ref)    |
//		+-----|-----+-----|-----+
//		      |           |
//		      ↓           ↓
//		  (String[]  )  (String[]  )

		
		//以下で配列の初期化を行っているため、そこにアクセスする分には例外はでない
		array1[0] = new String[2];// array1[0] は長さ2のString配列
		array1[1] = new String[5];// array1[1] は長さ5のString配列
		
		int i = 97;
		for (int a = 0; a < array1.length; a++) {
		    for (int b = 0; b < array1.length; b++) {
		        array1[a][b] = "" + i;
		        i++;
		    }
		}
		for (String[] tmp : array1) {
		    for (String s : tmp) {
		        System.out.print(s + " ");
		    }
		    System.out.println();
		}
		
		
		test t = new test();
		System.out.println(t.numtest);
		
		//privateだからアクセス不可
//		testoya t2 = new testoya();
//		System.out.println(t2.numtest2);
		
		System.out.println(numstatic);
		numstatic += 100;
		System.out.println(numstatic);
		
	



 	}

}

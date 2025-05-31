package practice;

public class Sample9 {
	
	private int num;
	private String name;
	
	public Sample9(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	
	//Objectクラスを用いた、値が同じかを確認するメソッド
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		
		if(obj instanceof Sample9) { // オブジェクト instanceof クラス名 -> オブジェクトがクラス名のインスタンスなら true
			Sample9 s = (Sample9) obj; // Sample9 型として使えるように変換(キャスト)
			return s.num == this.num;
		}
		
		return false;
	}

}

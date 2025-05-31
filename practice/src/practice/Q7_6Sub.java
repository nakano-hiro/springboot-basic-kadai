package practice;

public class Q7_6Sub implements Q7_6If2 {
	
	@Override
	public void greet() {
		
		// superを使ってインターフェースからメソッドを呼び出す。
		//superで呼び出せるのは、直接のスーパークラス・直近のスーパーフェースのみ。
		//この場合、大元のIfはこのクラスでは継承していないのでできない
		Q7_6If2.super.greet();
		System.out.println("Q7_6Sub");
	}

}

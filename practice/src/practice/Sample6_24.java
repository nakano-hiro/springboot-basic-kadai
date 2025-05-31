package practice;

public class Sample6_24 {
	
	public Sample6_24() {
			this(null, 0);
			System.out.println("thisを使ったコンストラクタの呼び出しは、最初に記述しないとダメ(thisは１つしか定義できない)");
	}
	
	public Sample6_24(String str, int num) {
		System.out.println("ok");
	}

}

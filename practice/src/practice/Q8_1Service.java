package practice;

public class Q8_1Service {
	
	//インターフェース名を型として宣言
	private Q8_1if logic;
	
	//セッター
	public void setLogic(Q8_1if logic) {
		this.logic = logic;
	}
	
	
	public void doProcess(String name) {
		System.out.println("start");
		this.logic.greet(name);
		System.out.println("end");
	}
	

}

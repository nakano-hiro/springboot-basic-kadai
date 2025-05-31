package practice;

public class JyankenExec {

	public static void main(String[] args) {
		
		Jyanken battle = new Jyanken();

		//		battle.getMyChoice();
		//		battle.getRandom();
		battle.playGame(battle.getMyChoice(), battle.getRandom());

	}

}

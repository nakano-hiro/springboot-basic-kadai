package practice;

import java.util.HashMap;
import java.util.Scanner;

public class Jyanken {

	public String getMyChoice() {

		while (true) {
			System.out.println("グー：r、チョキ：s、パー：p のどれかを選んで入力してください。");

			Scanner scanner = new Scanner(System.in);

			String myChoice = scanner.next();

			if (!(myChoice.equals("r") || myChoice.equals("s") || myChoice.equals("p"))) {
				System.out.println("無効な値です。入力をやり直してください");
				continue;
			} else {
				scanner.close();
				return myChoice;
			}
		}

	}
	
	public String getRandom() {
		String[] rival = {"r","s","p"};
		
		String rivalChoice = rival[(int) Math.floor(Math.random() * 3)];
		
		return rivalChoice;
	}
	
	public void playGame(String myChoice, String rivalChoice) {
		
		HashMap<String,String> jyankenHand = new HashMap<>();
		
		jyankenHand.put("r", "グー");
		jyankenHand.put("s","チョキ");
		jyankenHand.put("p", "パー");
		
		System.out.println("あなたは：" + jyankenHand.get(myChoice));
		System.out.println("あいては：" + jyankenHand.get(rivalChoice));
		
		if("r".equals(myChoice) && "s".equals(rivalChoice) ||
		   "s".equals(myChoice) && "p".equals(rivalChoice) ||
		   "p".equals(myChoice) && "r".equals(rivalChoice)
		   ) {
			System.out.println("あなたの勝ち");
		}else if (myChoice == rivalChoice) {
			System.out.println("あいこ");
		}else {
			System.out.println("あなたの負け");
		}
		
		
	}

}

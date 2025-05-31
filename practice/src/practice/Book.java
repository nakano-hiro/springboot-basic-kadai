package practice;

public class Book {

	private String title;
	private int price;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setPrice(int price) {
		if (price < 0) {
			System.out.println("値が正しくありません。0円以上を入力してください");
		} else {
			this.price = price;
		}
	}
	
	public int getPrice() {
		return this.price;
	}

}

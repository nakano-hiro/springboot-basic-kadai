package practice;

public class Sample10 {
	private int num;
	
	public Sample10(int num) {
		this.num = num;
	}
	
	
	public boolean equals(Sample10 obj) {
		if(obj == null) {
			return false;
		}
		
		return this.num == obj.num;
	}

}


public class letter {
	
	String let;
	int count;
	double percent;
	
	
	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public void incrementCount(){
		count++;
	}

	public String getLet() {
		return let;
	}


	public void setLet(String let) {
		this.let = let;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public letter(String l,int c){
		this.let = l;
		this.count = c;
	}
	
	public letter(String l,double d){
		this.let = l;
		this.percent =d;
		
	}


}

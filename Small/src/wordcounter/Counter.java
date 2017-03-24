package wordcounter;

public	class Counter {
	String string;
	int count;
	
	public String getString() {
		return string;
	}
	
	public int getCount() {
		return count;
	}
	
	public void incrementCount(int increment) {
		count+=increment;
	}
	
	public void incrementCount() {
		count++;
	}
	
	public Counter(String string, int count) {
		this.string = string;
		this.count = count;
	}

	@Override
	public String toString() {
		return string+"\t"+count;
	}
}
package wordcounter;

public class Counter implements Comparable<Counter> {
	private final String string;
	private int count;
	
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
		return count+"\t"+string;
	}

	@Override
	public int compareTo(Counter that) {
		if (this.getCount()<that.getCount()) return 1;
		if (this.getCount()>that.getCount()) return -1;
		return 0;
	}
	
//	@Override
//	public int compareTo(Counter that) {
//		return this.getString().compareTo(that.getString());
//	}
}
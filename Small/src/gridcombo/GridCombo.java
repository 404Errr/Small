package gridcombo;

import util.Util;

public class GridCombo {
	public static void main(String[] args) { 
//		int[][] array = new int[3][3];
		String array = "6,5,4;5,6,5;";
		
//		Util.printArray(array);
		int[][] blah = Util.StringToArray(array);
		Util.printArray(blah);
	}
	

}

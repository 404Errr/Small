package roman;

import java.util.Scanner;

public class Roman {
	public static final char[] NUMERALS = 	{'I', 'V', 'X', 'L', 'C'};//, 'D', 'M'};
	public static final char[] NUMERALS_REVERSE = Util.reverseOrder(NUMERALS);
	public static final int[] VALUES = 		{  1,   5,  10,  50, 100};//, 500, 1000};
	public static final int[] VALUES_REVERSE = Util.reverseOrder(VALUES);
	
	public static void main(String[] args) {
		
//		Util.printArray(NUMERALS);
//		Util.printArray(NUMERALS_REVERSE);
//		Util.printArray(VALUES);
//		Util.printArray(VALUES_REVERSE);
		
		
		Scanner scan = new Scanner(System.in);
		while (new Boolean(true)) {
			String input = scan.next().toUpperCase(), output = input;
//			if (Util.containsOnly(input, NUMERALS)) {
//				output = String.valueOf(romanToInt(input));
//			}
//			else if (Util.isNumeric(input)) {
				output = intToRoman(Integer.parseInt(input));
//			}
			System.out.println(output);
		}
		scan.close();
	}

	public static String intToRoman(int number) {
		if (number>=5000) return "";
		StringBuilder sb = new StringBuilder();
		int currentNum = number;
		while (new Boolean(true)){
			for (int j = 0;j<VALUES_REVERSE.length;) {
				if (currentNum>=VALUES_REVERSE[j]) {
					sb.append(NUMERALS_REVERSE[j]);
					currentNum-=VALUES_REVERSE[j];
				}
				else j++;
			}
			int count = 0;
			for (int j = 1;j<sb.length();j++) {
				if (sb.charAt(j)==sb.charAt(j-1)) count++;
				if (count>=3) {
//					int k = 0;
//					for (;k<NUMERALS.length;k++) {
//						if (NUMERALS[k]==sb.charAt(j)) break;
//					}
//					sb.replace(j-3, sb.length(), NUMERALS[k]+""+NUMERALS[k+1]);
					
				}
			}
			
			
			if (currentNum<=0) break;
			
		}
		return sb.toString();
	}

	public static int romanToInt(String roman) {




		return 0;
	}


}

class Util {
	public static void printArray(int[] array) {
		for (int element:array) System.out.print(element+" ");
		System.out.println();
	}
	
	public static void printArray(char[] array) {
		for (char element:array) System.out.print(element+" ");
		System.out.println();
	}
	
	public static int[] reverseOrder(int[] array) {
		int[] temp = array.clone();
		for (int i = temp.length-1, j = 0;i>=0;i--,j++) {
			temp[i] = array[j];
		}
		return temp;
	}

	public static char[] reverseOrder(char[] array) {
		char[] temp = array.clone();
		for (int i = temp.length-1, j = 0;i>=0;i--,j++) {
			temp[i] = array[j];
		}
		return temp;
	}

	public static void addToEnd(String str, String toAdd) {
		str = str+toAdd;
	}
	
	public static void addToBeginning(String str, String toAdd) {
		str = toAdd+str;
	}
	
	public static boolean containsOnly(String string, char[] potentialcontent) {
		for (char character:string.toCharArray()) {
			boolean contains = false;
			for (char potentialMatch:potentialcontent) {
				if (character==potentialMatch) {
					contains = true;
				}
			}
			if (!contains) return false;
		}
		return true;
	}
	
	public static boolean isNumeric(String string) {
		for (char character:string.toCharArray()) {
			if (!Character.isDigit(character)) return false;
		}
		return true;
	}
}




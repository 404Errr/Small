package findlines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FindLines {
	private static final String WORD = "honest";
	private static final String[] LOCATION_SEPERATOR = {"ACT", "SCENE"};
	private static final String[] NAMES = {"BIANCA", "BRABANTIO", "CASSIO", "DESDEMONA", "EMILIA", "GRATIANO", "IAGO", "LODOVICO", "MONTANO", "OTHELLO", "RODERIGO"};
	private static String path = "src/findlines/othello";

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		List<String> names = new ArrayList<>();for (int i = 0;i<NAMES.length;i++) if (!names.contains(NAMES[i])) names.add(NAMES[i]);Collections.sort(names);for (int i = 0;i<names.size();i++) System.out.print("\""+names.get(i).toUpperCase()+"\", ");
		String play = fileToString(path);
		List<Line> lines = getLines(play);
		System.out.println("\n\n"+lines);
		System.out.println(((System.currentTimeMillis()-startTime)/1000f)+"\n\n");
	}

	private static List<Line> getLines(String play) {
		List<Line> lines = new ArrayList<>();
		List<String> fileLines = new ArrayList<>();
		try {
			File theFile = new File(path);
			Scanner scan = new Scanner(theFile);
			while (scan.hasNextLine()) fileLines.add(scan.nextLine());
			scan.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int[] currentLocation = {1, 1};
		int lineNumber = 0;
		Line currentLine = null;
		for (int i = 0;i<fileLines.size();i++) {
			if (fileLines.get(i).equals("")) continue;
			if (isSeperator(fileLines.get(i))!=-1) {
				int isSeperator = isSeperator(fileLines.get(i));
				String numeral = "";
				for (int j = 0;j<fileLines.get(i).length();j++) {
					if (fileLines.get(i).charAt(j)=='.') break;
					if (validNumeral(fileLines.get(i).charAt(j))) numeral+=fileLines.get(i).charAt(j);
				}
				currentLocation[isSeperator] = romanToInt(numeral);
				System.out.println(numeral);
				if (isSeperator==0) {
					currentLocation[1] = 1;
					lineNumber = 1;
				}
				System.out.println(fileLines.get(i)+"\n"+Arrays.toString(currentLocation));
				continue;
			}
			if (isName(fileLines.get(i))!=-1) {
				currentLine = new Line(getCopy(currentLocation), fileLines.get(i));
				lines.add(currentLine);
				continue;
			}
			if (currentLine!=null) {
				currentLine.addContent(fileLines.get(i), lineNumber);
				lineNumber++;
			}
		}
		return lines;
	}
//
//	private static boolean isUpper(String word) {
//		return word.length()>1&&word.toUpperCase().equals(word);
//	}

	private static int isName(String word) {
		for (int i = 0;i<NAMES.length;i++) if (word.equals(NAMES[i])) return i;
		return -1;
	}

	private static int isSeperator(String word) {
		for (int i = 0;i<LOCATION_SEPERATOR.length;i++) if (word.contains(LOCATION_SEPERATOR[i])) return i;
		return -1;
	}

	public static boolean validChar(char c) {
		if (Character.isAlphabetic(c)) return true;
		if (c=='-') return true;
		return false;
	}

	public static String fileToString(String path) {
		try {
			File theFile = new File(path);
			Scanner scan = new Scanner(theFile);
			StringBuilder output = new StringBuilder();
			while (scan.hasNextLine()) {
				output.append(scan.nextLine()+" ");
			}
			try {
				return output.toString();
			}
			finally {
				scan.close();
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("Can't find file at: "+path);
			System.exit(0);
		}
		return null;
	}

	private static boolean validNumeral(char c) {
		if (c=='C') return false;
		for (int i = 0;i<NUMERAL_CHARS.length;i++) if (NUMERAL_CHARS[i]==c) return true;
		return false;
	}

	private static final TreeMap<Integer, String> numerals = new TreeMap<>();
	private static final char[] NUMERAL_CHARS = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

	static {
		boolean p = true;
		for (int i = 1, pI = 0;i<NUMERAL_CHARS.length*2;i++, pI+=(i%5==0)?2:0) {
			numerals.put((int) (Math.pow(10,(((i-1)/4)+1)-1)*new int[] {1, 4, 5, 9}[(i-1)%4]), ((p=!p)?NUMERAL_CHARS[pI]:"")+""+NUMERAL_CHARS[i/2]);
		}
	}

	private static int MIN_VALUE = 1, MAX_VALUE = 4999;
	public static String intToRoman(int num) {
		if (num<MIN_VALUE||num>MAX_VALUE) throw new IllegalArgumentException("Number must be between "+MIN_VALUE+" and "+MAX_VALUE);
		return toRoman(num);
	}

	private static String toRoman(int number) {
		int lower = numerals.floorKey(number);
		if (number==lower) return numerals.get(number);
		return numerals.get(lower)+toRoman(number-lower);
	}

	public static int romanToInt(String roman) {
		roman = roman.toUpperCase();
		int number = fromRoman(roman);
		if (number==-1) throw new IllegalArgumentException("\""+roman+"\" is invalid");
		return number;
	}

	private static int fromRoman(String roman) {
		if (roman.isEmpty()) return 0;
		for (Map.Entry<Integer, String> set:numerals.descendingMap().entrySet()) {
			if (roman.startsWith(set.getValue())) {
				return set.getKey()+fromRoman(roman.substring(set.getValue().length()));
			}
		}
		return -1;
	}

	public static int[] getCopy(int[] array) {
		int[] newArray = new int[array.length];
		for (int i = 0;i<array.length;i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
}

class Line {
	private int[] location;//act, scene
	private String speaker;
	private List<LineLine> content;

	public Line(int[] location, String speaker) {
		this.location = location;
		this.speaker = speaker;
		content = new ArrayList<>();
	}

	public void addContent(String line, int lineNumber) {
		content.add(new LineLine(line, lineNumber));
	}

	public int[] getLocation() {
		return location;
	}

	public String getSpeaker() {
		return speaker;
	}

	public List<LineLine> getLines() {
		return content;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\nlocation = "+location[0]+", "+location[1]+"\n"+speaker+"\n");
		for (int i = 0;i<content.size();i++) str.append(content.get(i)+"\n");
		return str.toString();
	}
}

class LineLine {
	private int lineNumber;
	private String content;

	public LineLine(String content, int lineNumber) {
		this.lineNumber = lineNumber;
		this.content = content;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return lineNumber+"\t"+content;
	}
}
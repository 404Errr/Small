package findlines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import roman.Roman;

public class FindLines {
	private static final String[] LOCATION_SEPERATOR = {"ACT", "SCENE"};
	
	public static void main(String[] args) {
		String path = "src/findlines/othello";
		String play = fileToString(path);
//		System.out.print(play+"\n\n");
		List<Line> lines = find(play);
		System.out.println(lines);
	}
	
	private static List<Line> find(String play) {
		List<Line> lines = new ArrayList<>();
		long startTime = System.currentTimeMillis();
		List<String> rawWords = Arrays.asList(play.split(" ")), words = new ArrayList<>();
		for (int i = 0;i<rawWords.size();i++) {
			if (!rawWords.get(i).equals("")) {
				StringBuilder word = new StringBuilder();
				for (int j = 0;j<rawWords.get(i).length();j++) {
//					if (validChar(rawWords.get(i).charAt(j))) {
						word.append(rawWords.get(i).charAt(j));
//					}
				}
				words.add(word.toString()); 
			}
		}
		System.out.println(words);
		System.out.print("created word list\nsize = "+words.size()+"\t"+((System.currentTimeMillis()-startTime)/1000f)+"\n\n");
		int[] current = new int[LOCATION_SEPERATOR.length];
		for (int i = 0;i<words.size();i++) {
			if (isSeperator(words.get(i))!=-1) {
				String numeral = "";
				for (int j = 0;j<words.get(i+1).length();j++) if (Character.isAlphabetic(words.get(i+1).charAt(j))) numeral+=words.get(i+1).charAt(j);
				words.set(i+1, numeral);
				current[isSeperator(words.get(i))] = Roman.romanToInt(words.get(i+1));
				if (isSeperator())set act to 1
				System.out.println(i+"\t"+words.get(i)+"\t"+words.get(i+1));
				System.out.println(Arrays.toString(current));
				
			}
		}
		
		return lines;
	}
	
	private static int isSeperator(String word) {
		for (int i = 0;i<LOCATION_SEPERATOR.length;i++) if (word.equals(LOCATION_SEPERATOR[i])) return i;
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
}

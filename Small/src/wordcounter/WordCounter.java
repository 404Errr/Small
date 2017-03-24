package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import util.Util;

public class WordCounter {
	
	public static void main(String[] args) {
//		String path = "src/wordcounter/file";
		String path = "src/wordcounter/shake";
		List<Counter> wordCount = countWords(fileToString(path));
		for (int i = 0;i<wordCount.size();i++) {
			System.out.println(wordCount.get(i));
		}
	}
	
	public static boolean validChar(char c) {
		if (Character.isAlphabetic(c)) return true;
		if (c=='-') return true;
		return false;
	}
	
	public static List<Counter> countWords(String str) {
		List<Counter> count = new ArrayList<>();
		List<String> rawWords = Arrays.asList(str.split(" ")), words = new ArrayList<>();
		for (int i = 0;i<rawWords.size();i++) {
			if (!rawWords.get(i).equals("")) {
				StringBuilder word = new StringBuilder();
				for (int j = 0;j<rawWords.get(i).length();j++) {
					if (validChar(rawWords.get(i).charAt(j))) {
						word.append(rawWords.get(i).charAt(j));
					}
				}
				words.add(word.toString().toLowerCase()); 
			}
		}
		for (int i = 0;i<words.size();i++) {
			if (find(count, words.get(i))==-1) {
				count.add(new Counter(words.get(i), 0));
			}
		}
		for (int i = 0;i<words.size();i++) {
			count.get(find(count, words.get(i))).incrementCount();
		}
		Collections.sort(count);
		return count;
	}
	
	private static int find(List<Counter> count, String string) {
		for (int i = 0;i<count.size();i++) if (count.get(i).getString().equals(string)) return i;
		return -1;
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



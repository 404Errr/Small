package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import util.Util;

public class WordCounter {
	
	public static void main(String[] args) {
		List<Counter> wordCount = countWords(fileToString("src/wordcounter/file"));
		for (int i = 0;i<wordCount.size();i++) {
			System.out.println(wordCount.get(i));
		}
	}
	
	public static List<Counter> countWords(String str) {
		List<Counter> count = new ArrayList<>();
		List<String> rawWords = Arrays.asList(str.split(" ")), words = new ArrayList<>();
		for (int i = 0;i<rawWords.size();i++) {
			if (!rawWords.get(i).equals("")) {
				StringBuilder word = new StringBuilder();
				for (int j = 0;j<rawWords.get(i).length();j++) {
					if (Character.isAlphabetic(rawWords.get(i).charAt(j))) {
						word.append(rawWords.get(i).charAt(j));
					}
				}
				words.add(word.toString()); 
			}
		}
		System.out.println(words);
		for (int i = 0;i<words.size();i++) {
			if (!count.contains(words.get(i))) {
				count.add(new Counter(words.get(i), 1));
			}
		}
		for (int i = 0;i<words.size();i++) {
			count.get(count.indexOf(words.get(i))).incrementCount();
		}
		System.out.println(str+"\n"+words);
		return count;
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



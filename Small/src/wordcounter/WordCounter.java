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
		Map<String, Integer> wordCount = countWords(fileToString("src/wordcounter/file"));
	}
	
	public static Map<String, Integer> countWords(String str) {
		Map<String, Integer> count = new TreeMap<String, Integer>();
		List<String> rawWords = Arrays.asList(str.split(" ")), words = new ArrayList<>();
		for (int i = 0;i<rawWords.size();i++) {
//			if (!rawWords.get(i).equals("")) {
				words.add(rawWords.get(i)); 
//			}
		}
		
		for (int i = 0;i<words.size();i++) {
			if (count.containsKey(words.get(i))) {
				//TODO
			}
			else {
				count.put(words.get(i), 1);
			}
		}
		
		System.out.println(str);
		System.out.println(words);
		
		
		
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

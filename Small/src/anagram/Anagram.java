package anagram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.Util;

class Tester {
	public static void main(String[] args) {
		Anagram.initDictionary();
		Scanner scan = new Scanner(System.in);
		while (new Boolean(true)) {
			String str = scan.nextLine().toLowerCase();
			long startTime = System.currentTimeMillis();
			System.out.println();
//			List<String> anagrams = Anagram.findAnagrams(str, false);
//			List<String> anagrams = Anagram.findAnagrams(str, true);
			List<String> anagrams = Anagram.findAnagramsSpaces(str);
			StringBuilder sb = new StringBuilder();
			for (int i = 0;i<anagrams.size();i++) sb.append(anagrams.get(i)+"\n");
			System.out.println(sb);
			System.out.println((System.currentTimeMillis()-startTime)/1000f+" s\n");
		}
		scan.close();
	}
}

public class Anagram {
	private static final String DICTIONARY_PATH = "src/anagram/dic";
	private static List<String> dictionary;
//	private static List<List<String>> dictionaryByLength;

	public static void initDictionary() {
		try {
//			StringBuilder str = new StringBuilder(); 
			dictionary = Files.readAllLines(Paths.get(DICTIONARY_PATH));
//			str.append("dictionary length = "+dictionary.size()+"\n");
//			int longestWord = 0;
//			for (int i = 0;i<dictionary.size();i++) {
//				if (dictionary.get(i).length()>longestWord) longestWord = dictionary.get(i).length();
//			}
//			str.append("longest = "+longestWord+"\n");
//			dictionaryByLength = new ArrayList<>();
//			dictionaryByLength.add(new ArrayList<>());//empty 0
//			for (int len = 1;len<=longestWord;len++) {
//				dictionaryByLength.add(new ArrayList<>());
//				for (int i = 0;i<dictionary.size();i++) {
//					if (dictionary.get(i).length()==len) {
//						dictionaryByLength.get(len).add(dictionary.get(i));
//					}
//				}
//				str.append(len+"\t"+dictionaryByLength.get(len).size()+"\n");
//			}
//			System.out.println(str.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<String> anagrams = new ArrayList<>();
	public static List<String> findAnagramsSpaces(String string) {
		anagrams = new ArrayList<>();
		List<Character> stringChars = new ArrayList<>();
		for (char c:string.toCharArray()) if (c!=' ') stringChars.add(c);
//		final char[] stringChars = string.toCharArray();
		System.out.println("stringChars\t"+stringChars);
		final int maxSpaces = string.length()/2;
		for (int spaceCount = 0;spaceCount<maxSpaces;spaceCount++) {
			List<Character> tempStringChars = Util.getCopy(stringChars);
			for (int i = 0;i<spaceCount;i++) tempStringChars.add(' ');
			for (int i = 0;i<dictionary.size();i++) {
				String dicString = dictionary.get(i);
				if (dicString.length()==string.length()) continue;
				List<Character> wordChars = new ArrayList<>();
				for (int j = 0;j<dicString.length();j++) wordChars.add(dicString.charAt(j));
				for (int j = 0;j<tempStringChars.size();j++) wordChars.remove(tempStringChars.get(j));
				if (!wordChars.isEmpty()) continue; 
				anagrams.add(dicString);
				
			}
		}		
		return anagrams;
	}
	
	public static List<String> findAnagrams(String string, boolean onlySameLength) {
		List<String> anagrams = new ArrayList<>();
		final char[] stringChars = string.toCharArray();
		for (int i = 0;i<dictionary.size();i++) {
			String dicString = dictionary.get(i);
			if (onlySameLength&&dicString.length()!=string.length()||!onlySameLength&&dicString.length()>string.length()) continue;
			List<Character> wordChars = new ArrayList<>();
			for (int j = 0;j<dicString.length();j++) wordChars.add(dicString.charAt(j));
			for (int j = 0;j<stringChars.length;j++) wordChars.remove((Character) stringChars[j]);
			if (wordChars.size()>0) continue;
			anagrams.add(dicString);
		}
		return anagrams;
	}
}

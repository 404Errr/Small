package anagram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (new Boolean(true)) {
			String str = scan.next().toLowerCase();
			long startTime = System.currentTimeMillis();
			System.out.println();
			List<String> anagrams = Anagram.findAnagrams(str);
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

	static {
		try {
			dictionary = Files.readAllLines(Paths.get(DICTIONARY_PATH));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> findAnagrams(String string) {
		List<String> anagrams = new ArrayList<>();
		final char[] stringChars = string.toCharArray();
		for (int i = 0;i<dictionary.size();i++) {
			if (dictionary.get(i).length()!=string.length()) continue;
			List<Character> wordChars = new ArrayList<>();
			for (int j = 0;j<string.length();j++) wordChars.add(dictionary.get(i).charAt(j));
			for (int j = 0;j<stringChars.length;j++) wordChars.remove((Character) stringChars[j]);
			if (wordChars.size()>0) continue;
			anagrams.add(dictionary.get(i));
		}

		return anagrams;
	}
}

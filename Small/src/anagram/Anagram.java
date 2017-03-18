//https://github.com/dwyl/english-words
//http://app.aspell.net/create

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
			System.out.println("\n");
			List<String> anagrams = Anagram.getAnagrams(str);
			StringBuilder sb = new StringBuilder();
			for (int i = 0;i<anagrams.size();i++) sb.append(anagrams.get(i)+"\n");
			System.out.println(sb+"\n");
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

	public static List<String> getAnagrams(String string) {
		for (int i = 0;i<string.length();i++) if (!Character.isAlphabetic(string.charAt(i))) throw new IllegalArgumentException("Input must me alphabetic");
		List<String> anagrams = getStringPermutations(string);
		anagrams = stripInvalid(anagrams);
		if (!anagrams.contains(string)) anagrams.add(0, string);
		return anagrams;
	}


	private static List<String> getStringPermutations(String string) {
		List<String> combos = new ArrayList<>();
		char[] str = string.toCharArray();
		int[] c = new int[string.length()];
		for (int i = 0;i<string.length();i++) {
			c[i] = 0;
		}
		combos.add(String.valueOf(str));
		int i = 0;
		while (i<string.length()) {
			if (c[i]<i) {
				if (i%2==0) str = swap(str, 0, i);
				else str = swap(str, c[i], i);
				if (!combos.contains(String.valueOf(str))) combos.add(String.valueOf(str));
				c[i]++;
				i = 0;
			}
			else {
				c[i] = 0;
				i++;
			}
		}
		return combos;
	}

	private static char[] swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
		return str;
	}

	private static List<String> stripInvalid(List<String> strs) {
		for (int i = strs.size()-1;i>=0;i--) {
			if (!dictionary.contains(strs.get(i))) {
				strs.remove(i);
			}
		}
		return strs;
	}
}

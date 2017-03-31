package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordCounter {
	public static final int B = -1, W = 1, N = 0;//blacklist whitelist none
	
	private static final int FILTER = N;
	private static final List<String> FILTER_ITEMS = Arrays.asList();
	
	public static void main(String[] args) {
//		String path = "src/wordcounter/file";
		String path = "src/wordcounter/li";
//		String path = "src/wordcounter/othello";
//		String path = "src/wordcounter/shake";
		long startTime = System.currentTimeMillis();
		List<Counter> wordCount = countWords(fileToString(path));
		for (int i = 0;i<wordCount.size();i++) {
			float percentage = (int) ((wordCount.get(i).getCount()/(float)wordCount.size()*100f)*10000)/10000f;
			System.out.println(i+"\t"+wordCount.get(i)+"\t\t"+percentage+"%");
		}
		System.out.println("\n"+((System.currentTimeMillis()-startTime)/1000f));
	}
	
	public static boolean validChar(char c) {
		if (Character.isAlphabetic(c)) return true;
		if (c=='-') return true;
		return false;
	}
	
	public static List<Counter> countWords(String str) {
		long startTime = System.currentTimeMillis();
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
		System.out.print("initialized word list\nsize = "+words.size()+"\t"+((System.currentTimeMillis()-startTime)/1000f)+"\n\n");
		final int inc = words.size()/20;
		for (int i = 0;i<words.size();i++) {
			int index = find(count, words.get(i));
			if (index==-1) {
				count.add(new Counter(words.get(i), 1));
			}
			else count.get(index).incrementCount();
			if (i%inc==0) System.out.print(">");
		}
		System.out.print("\n\n");
		System.out.print("counted words"+"\t"+((System.currentTimeMillis()-startTime)/1000f)+"\n\n");
		Collections.sort(count);
		count = filter(count);
		return count;
	}
	
//	public static List<Counter> countWords(String str) {
//		List<Counter> count = new ArrayList<>();
//		List<String> rawWords = Arrays.asList(str.split(" ")), words = new ArrayList<>();
//		for (int i = 0;i<rawWords.size();i++) {
//			if (!rawWords.get(i).equals("")) {
//				StringBuilder word = new StringBuilder();
//				for (int j = 0;j<rawWords.get(i).length();j++) {
//					if (validChar(rawWords.get(i).charAt(j))) {
//						word.append(rawWords.get(i).charAt(j));
//					}
//				}
//				words.add(word.toString().toLowerCase()); 
//			}
//		}
//		System.out.print("initialized word list\nsize = "+words.size()+"\n\n");
//		for (int i = 0;i<words.size();i++) {
//			if (find(count, words.get(i))==-1) {
//				count.add(new Counter(words.get(i), 0));
//			}
//		}
//		System.out.print("initialized counters\nsize = "+count.size()+"\n\n");
//		for (int i = 0;i<words.size();i++) {
//			count.get(find(count, words.get(i))).incrementCount();
//		}
//		System.out.print("counted words\n\n");
//		Collections.sort(count);
//		count = filter(count);
//		return count;
//	}
	
	private static int find(List<Counter> count, String string) {
		for (int i = 0;i<count.size();i++) {
			if (count.get(i).getString().equals(string)) return i;
		}
		return -1;
	}
	
	
	public static List<Counter> filter(List<Counter> list) {
		switch (FILTER) {
		case W:
			for (int i = list.size()-1;i>=0;i--) if (!FILTER_ITEMS.contains(list.get(i).getString())) list.remove(i);
			return list;
		case B:
			for (int i = list.size()-1;i>=0;i--) if (FILTER_ITEMS.contains(list.get(i).getString())) list.remove(i);
			return list;
		default:
			return list;
		}
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



package linefinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LineFinder {
	public static final int B = -1, W = 1, N = 0;//blacklist whitelist none

	public static final String[] WORD = {"honest"};

	public static void main(String[] args) {
		String path = "src/linefinder/file";
		long startTime = System.currentTimeMillis();
		List<Line> lines = findLines(fileToString(path));
		for (int i = 0;i<lines.size();i++) {
			System.out.println(i+"\t"+lines.get(i));
		}
		System.out.println("\n"+((System.currentTimeMillis()-startTime)/1000f));
	}

	public static boolean validChar(char c) {
		if (Character.isAlphabetic(c)||c=='-') return true;
		return false;
	}

	public static List<Line> findLines(String str) {
		List<Line> lines = new ArrayList<>();
		List<String> rawWords = Arrays.asList(str.split(" ")), names = new ArrayList<>();
		for (int i = 0;i<rawWords.size();i++) {
			if (!rawWords.get(i).equals("")) {
				StringBuilder word = new StringBuilder();
				for (int j = 0;j<rawWords.get(i).length();j++) {
					if (validChar(rawWords.get(i).charAt(j))) {
						word.append(rawWords.get(i).charAt(j));
					}
				}
				if (isUpper(word.toString())&&!names.contains(word.toString().toLowerCase())) names.add(word.toString().toLowerCase());
//				words.add(word.toString().toLowerCase());
			}
		}
//		System.out.print("initialized word list\nsize = "+words.size()+"\t"+((System.currentTimeMillis()-startTime)/1000f)+"\n\n");
//		final int inc = words.size()/20;
//		for (int i = 0;i<words.size();i++) {
//			int index = find(count, words.get(i));
//			if (index==-1) {
//				count.add(new Counter(words.get(i), 1));
//			}
//			else count.get(index).incrementCount();
//			if (i%inc==0) System.out.print(">");
//		}
		System.out.println(names);
		return lines;
	}

	private static boolean isUpper(String word) {
		return word.length()>1&&word.toUpperCase().equals(word);
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



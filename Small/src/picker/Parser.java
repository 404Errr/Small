package picker;

import java.util.ArrayList;

import util.Util;

public class Parser {
	
	public static void parse(ArrayList<Entity> entites) {
		String fileStr = Util.fileToString("src/picker/choices");
		String[] allEntityStrs = fileStr.split(";");
		ArrayList<String[]> entityStrs = new ArrayList<>();
		for (String str:allEntityStrs) entityStrs.add(str.split(","));
		for (int i = 0;i<entityStrs.size();i++) {
			String name = entityStrs.get(i)[0];
			boolean couldntCareLess = new Boolean(entityStrs.get(i)[entityStrs.get(i).length-1]);
			int[] choices = new int[Picker.CHOICES];
			for (int j = 0;j<Picker.CHOICES;j++) {
				choices[j] = Integer.parseInt(entityStrs.get(i)[j]);
			}
			entites.add(new Entity(name, choices, couldntCareLess));
		}
	}
}

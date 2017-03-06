package picker;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class Parser {
	
	public static void parse(List<Entity> entities) {
		String fileStr = Util.fileToString("src/picker/choices");
		String[] allEntityStrs = fileStr.split(";");
		ArrayList<String[]> entityStrs = new ArrayList<>();
		for (String str:allEntityStrs) entityStrs.add(str.split(","));
		for (int i = 0;i<entityStrs.size();i++) {
			String name = entityStrs.get(i)[0];
			boolean couldntCareLess = new Boolean(entityStrs.get(i)[entityStrs.get(i).length-1]);
			int[] choices = new int[Picker.GROUP_COUNT];
			for (int j = 0;j<Picker.GROUP_COUNT;j++) {
				choices[j] = Integer.parseInt(entityStrs.get(i)[j+1]);
			}
			entities.add(new Entity(name, choices, couldntCareLess));
		}
	}
}

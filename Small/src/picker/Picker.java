package picker;

import java.util.ArrayList;

public class Picker {
	final static int CHOICES = 4, GROUPS;
	
	private static ArrayList<Entity> entites;
	
	public static void main(String[] args) {
		entites = new ArrayList<>();
		Parser.parse(entites);
		for (Entity entity:entites) {
			System.out.println(entity);
		}
	}
}

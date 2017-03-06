package picker;

import java.util.ArrayList;
import java.util.List;

public class Picker {
	final static int GROUP_COUNT = 4;
	
	private static List<Entity> entities;
	private static List<ArrayList<Entity>> groups;
	
	public static void main(String[] args) {
		entities = new ArrayList<>();
		groups = new ArrayList<ArrayList<Entity>>();
		Parser.parse(entities);
		for (Entity entity:entities) System.out.println(entity);
		
		groups = findGroups(entities);
	}
	
	public static List<ArrayList<Entity>> findGroups(List<Entity> entities) {
		final int groupSize = entities.size()/GROUP_COUNT;
		
		
		
		
		
		
		return groups;
		
	}
	
	public static int getScore(List<Entity> group, int choiceNum) {
		int total = 0;
		for (Entity entity:group) {
			total+=GROUP_COUNT-entity.getChoices()[choiceNum]+1;
		}
		return total;
	}
}

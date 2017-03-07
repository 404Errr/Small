package picker;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class Picker {
	final static int GROUP_COUNT = 4;
	
	private static List<Entity> entities;
	private static List<Entity> groups;
	
	public static void main(String[] args) {
		entities = new ArrayList<>();
		groups = new ArrayList<Entity>();
		Parser.parse(entities);
		Util.printArray(entities);
		System.out.print("\n\n");
		groups = findBestGroups(entities);
		for (int i = 0;i<groups.size();i++) Util.printArray(groups);
	}
	
	public static List<Entity> findBestGroups(List<Entity> entities) {
		
		combos(entities, 0, null);
		
		return entities;
		
	}
	
	static void combos(List<Entity> arr, int k, List<Entity> best){
		for (int i = k;i<arr.size();i++){
			swap(i, k, arr);
			combos(arr, k+1, best);
			swap(i, k, arr);
		}
		if (k==arr.size()-1) {
			Util.printArray(arr);
		}
	}
	
	private static int getCost(List<Entity> entities) {
		if (entities==null) return Integer.MAX_VALUE;
		return (int) (Math.random()*30);
	}
	
	private static int getGroupsCost(List<ArrayList<Entity>> groups) {
		int total = 0;
		for (int i = 0;i<GROUP_COUNT;i++) {
			total+=getGroupCost(groups.get(i), i);
		}
		return total;
	}
	
	private static int getGroupCost(List<Entity> group, int choiceNum) {
		int total = 0;
		for (Entity entity:group) {
			total+=entity.getChoices()[choiceNum];
		}
		return total;
	}
	
	public static <T> void swap(int i1, int i2, List<T> array) {
		T temp = array.get(i1);
		array.set(i1, array.set(i2, temp));
	}
}

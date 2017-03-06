package picker;

import java.util.Arrays;

public class Entity {
	final String name;
	final int[] choices;
	final boolean couldntCareLess;
	
	public int[] getChoices() {
		return choices;
	}
	public boolean couldntCareLess() {
		return couldntCareLess;
	}
	public Entity(String name, int[] choices, boolean couldntCareLess) {
		this.name = name;
		this.choices = choices;
		this.couldntCareLess = couldntCareLess;
	}
	
	@Override
	public String toString() {
		return "name="+name+", choices=" + Arrays.toString(choices)+", couldntCareLess="+couldntCareLess;
	}
	
	
}

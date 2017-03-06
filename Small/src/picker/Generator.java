package picker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Generator {
//	final static String[] names;
	public static void main(String[] args) {
		for (int i = 0;i<40;i++) {
			System.out.print("name"+",");
			ArrayList<Integer> choices = new ArrayList<>();
			for (int j = 0;j<Picker.GROUP_COUNT;j++) choices.add(j);
			Collections.shuffle(choices);
			for (int j = 0;j<Picker.GROUP_COUNT;j++) {
				System.out.print(choices.get(j)+1+",");
			}
			
			System.out.println((new Random().nextBoolean()&&new Random().nextBoolean())+";");
		}
	}
}

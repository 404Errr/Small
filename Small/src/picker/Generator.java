package picker;

import java.util.Random;

public class Generator {
//	final static String[] names;
	public static void main(String[] args) {
		for (int i = 0;i<20;i++) {
			System.out.print("name"+",");
			for (int j = 0;j<Picker.CHOICES;j++) {
				System.out.print(new Rand om().nextInt(4)+1+",");//FIXME
			}
			
			System.out.println((new Random().nextBoolean()&&new Random().nextBoolean())+";");
		}
	}
}

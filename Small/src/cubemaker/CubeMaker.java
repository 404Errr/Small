package cubemaker;

import java.util.Random;

public class CubeMaker {
	public static final int SIZE = 3;
	private static final int Z = 0, Y = 1, X = 2;
	public static Random rand;
	
	public static void main(String[] args) {
		rand = new Random();
		make();
	}
	
	public static void make() {
		int[][][] cube = null;
		int totalCount = 0, currentCount = 0, currentColor = 0;
		boolean invalid = true;
		int[] current = {0, 0, 0};
		while (totalCount<=27) {
			if (invalid) {
				cube = new int[SIZE][SIZE][SIZE];
				for (int z = 0;z<cube.length;z++)
					for (int y = 0;y<cube[0].length;y++)
						for (int x = 0;x<cube[0][0].length;x++)
							cube[z][y][x] = -1;
				totalCount = 0;
				currentCount = 0;
				currentColor = 0;
				invalid = false;
			}
			boolean acted = false;
			int attempts = 0;
			while (!acted) {hey look over here!!!
				if (r(6)&&current[Z]>0) {//TODO check if its -1
					acted = true;
					current[Z]--;
				}
				if (r(6)&&current[Y]>0) {
					acted = true;
					current[Y]--;
				}
				if (r(6)&&current[X]>0) {
					acted = true;
					current[X]--;
				}
				if (r(6)&&current[Z]<cube.length-1) {
					acted = true;
					current[Z]--;
				}
				if (r(6)&&current[Y]<cube[0].length-1) {
					acted = true;
					current[Y]--;
				}
				if (r(6)&&current[X]<cube[0][0].length-1) {
					acted = true;
					current[X]--;
				}
				if (attempts>100) {
					invalid = true;
					break;
				}
				attempts++;
			}
			
			
			current[Z][Y][X] = currentColor;
			
			
			if (currentCount>rand.nextInt(3)+4) {
				currentColor++;
			}
			if (currentColor>5) invalid = true;
			currentCount++;
			totalCount++;
		}
	}
	
	private static boolean r(int choices) {
		return rand.nextInt(choices)==0;
	}
}

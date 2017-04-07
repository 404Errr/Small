package cubemaker;

import java.util.Arrays;
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
		int totalCount = 0, currentCount = 0, currentColor = 1;
		boolean invalid = true;
		Coord c = new Coord();
		while (true) {//totalCount<=27) {
			System.out.println(c);
			if (invalid) {
				c.reset();
				
				System.out.println("invalid");
				totalCount = 0;
				currentCount = 0;
				currentColor = 1;
				invalid = false;
			}
			int attempts = 0;
			while (true) {
				if (inBounds(c.getZ()-1)&&cube[c.getZ()-1][c[Y]][c[X]]==-1&&r(6)) {
					c.setZ(c.getZ()-1);
					break;
				}
				if (inBounds(c[Y]-1)&&cube[c[Z]][c[Y]-1][c[X]]==-1&&r(6)) {
					c[Y]--;
					break;
				}
				if (inBounds(c[X]-1)&&cube[c[Z]][c[Y]][c[X]-1]==-1&&r(6)) {
					c[X]--;
					break;
				}
				if (inBounds(c[Z]+1)&&cube[c[Z]+1][c[Y]][c[X]]==-1&&r(6)) {
					c[Z]++;
					break;
				}
				if (inBounds(c[Y]+1)&&cube[c[Z]][c[Y]+1][c[X]]==-1&&r(6)) {
					c[Y]++;
					break;
				}
				if (inBounds(c[X]+1)&&cube[c[Z]][c[Y]][c[X]+1]==-1&&r(6)) {
					c[X]++;
					break;
				}
				if (attempts>100) {
					invalid = true;
					break;
				}
				attempts++;
			}
			cube[c[Z]][c[Y]][c[X]] = currentColor;
			currentCount++;
			if (currentCount>5) {
				currentColor++;
				currentCount = 0;
			}
//			totalCount++;
//			if (currentCount>rand.nextInt(3)+4) {
//				currentColor++;
//				currentCount = 0;
//				if (currentColor>5) invalid = true;
//			}
			System.out.println("currentCount = "+currentCount+"\ttotalCount = "+totalCount+"\tcolor = "+currentColor); 
			print(cube);
		}
	}
	
	private static boolean inBounds(int val) {
		return !(val<0||val>SIZE-1);
	}
	
//	private static boolean inBounds(int x, int y, int z) {
//		return !(x<0||y<0||z<0||x>=SIZE-1||y>=SIZE-1||z>=SIZE-1);
//	}
	
	private static boolean r(int choices) {
		return rand.nextInt(choices)==0;
	}
	
	private static void print(int[][][] array) {
		StringBuilder str = new StringBuilder();
		for (int z = 0;z<array.length;z++) {
			for (int y = 0;y<array[0].length;y++) {
				for (int x = 0;x<array[0][0].length;x++) {
					if (array[z][y][x]==-1) str.append("0");
					else str.append(array[z][y][x]);
				}
				str.append("\n");
			}
			if (z<array.length-1) {
				for (int i = 0;i<array[0][0].length;i++) str.append("-");
				str.append("\n");
			}
		}
		System.out.println(str.toString());
		
	}
}

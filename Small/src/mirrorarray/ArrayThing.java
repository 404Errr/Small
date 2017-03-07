package mirrorarray;

public class ArrayThing {
	
	private static int[][] array;
	
	public static void main(String[] args) {
		array = getRandomArray(9, 9);
//		mirrorArray(array, true, true);
		mirrorArrayDiagonal(array, false, true);
		printArray(array);
	}
	
	private static void mirrorArrayDiagonal(int[][] array, boolean tLBR, boolean tRBL) {
		if (tLBR) for (int r = 0;r<array.length;r++) {
			for (int c = 0;c<array[0].length;c++) {
				array[c][r] = array[r][c];
			}
		}
		if (tRBL) for (int r = 0;r<array.length;r++) {
			for (int c = 0;c<array[0].length;c++) {
				array[c][r] = array[array.length-1-r][array[0].length-1-c];
			}
		}
	}

	private static void mirrorArray(int[][] array, boolean yAxis, boolean xAxis) {
		if (yAxis) for (int r = 0;r<array.length;r++) {
			for (int cR = array[0].length-1, cL = 0;cL!=cR;cR--, cL++) {
				array[r][cL] = array[r][cR];
			}
		}
		if (xAxis) for (int rR = array.length-1, rL = 0;rL!=rR;rR--, rL++) {
			for (int c = 0;c<array[0].length;c++) {
				array[rL][c] = array[rR][c];
			}
		}
	}
	
	
	private static final int RANDOM_LIMIT = 9;
	private static int[][] getRandomArray(int width, int height) {
		int[][] array = new int[height][width];
		
		for (int r = 0;r<array.length;r++) {
			for (int c = 0;c<array[0].length;c++) {
				array[r][c] = new Random().nextInt(RANDOM_LIMIT+1);
			}
		}
		return array;
	}
	
	private static void printArray(int[][] array) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0;r<array.length;r++) {
			for (int c = 0;c<array[0].length;c++) {
				sb.append(array[r][c]+",");
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
		}
		System.out.println(sb.toString());
	}
}

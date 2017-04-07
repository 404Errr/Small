package cubemaker;

public class Cube {
	private int[][][] cubies;
	private final int size;
	
	public int[][][] getCubies() {
		return cubies;
	}

	public Cube(int size) {
		this.size = size;
		cubies = new int[size][size][size];
	}

	public void reset() {
		for (int z = 0;z<size;z++) {
			for (int y = 0;y<size;y++) {
				for (int x = 0;x<size;x++) {
					cubies[z][y][x] = -1;
				}
			}
		}
	}
	
}
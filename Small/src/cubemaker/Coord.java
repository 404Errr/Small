package cubemaker;

public class Coord {
	private int x, y, z;
	
	void reset() {
		x = 0;
		y = 0;
		z = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "x "+x+"\ty "+y+"\t "+z;
	}
	
	
}

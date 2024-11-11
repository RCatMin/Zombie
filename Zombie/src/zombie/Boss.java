package zombie;

import java.util.Random;

public class Boss extends Zombie {

	Random ran = new Random();
	
	private int megicPoint;
	
	public int getMegicPoint() {
		return megicPoint;
	}
	
	public void setMegicPoint(int value) {
		megicPoint = value;
	}
	
	public Boss(int position, int health, int max, int megicPoint) {
		super(position, health, max);
		this.megicPoint = megicPoint;
	}
	
	
	

	

}

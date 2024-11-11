package zombie;

import java.util.Random;

abstract public class Unit {
	Random ran;
	
	private int health;
	private int position;
	private int megicPoint;
	
	int max; // 최대값

	public Unit (int position, int health, int megicPoint, int max) {
		this.health = health;
		this.position = position;
		this.megicPoint = megicPoint;
		this.max = max;
		
		ran = new Random();
	}
	
	public int getPosition () {
		return position;
	}
	
	public void setPosition (int position) {
		this.position = position;
	}
	
	public int getHealth () {
		return health;
	}
	
	public void setHealth (int health) {
		this.health = health;
	}
	
	public int getMegicPoint () {
		return megicPoint;
	}
	
	public void setMegicPoint (int megicPoint) {
		this.megicPoint = megicPoint;
	}
	
	public int getMax () {
		return max;
	}
}

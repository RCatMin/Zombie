package zombie;

import java.util.Random;

abstract public class Unit {
	Random ran;
	
	private int health;
	private int position;
	
	int max; // 최대값

	public Unit (int position, int health, int max) {
		this.health = health;
		this.position = position;
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
	
	public int getMax () {
		return max;
	}
}

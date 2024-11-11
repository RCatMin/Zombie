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
	
	public void attack (Unit Human) {
		
		int normalAttack = ran.nextInt(max);
		
		Human.setHealth(Human.getHealth() - power);
		Human.setMegicPoint(Human.getMegicPoint() + power);
		
		if (normalAttack > 20) {
			String message = String.format("Critical! 플레이어가 %d의 데미지를 받았습니다. \n 남은 체력 : %d", normalAttack, Human.getHealth());
			System.out.println (message);
		} else {
			String message = String.format("플레이어가 %d의 데미지를 받았습니다. \n 남은 체력 : %d", normalAttack, Human.getHealth());
			System.out.println (message);
		}
		
		
	}
	
	
	

	

}

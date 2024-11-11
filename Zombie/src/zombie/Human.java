package zombie;

public class Human extends Unit{
	
	int power;
	int potion;
	int ammo;

	public Human(int position, int health, int megicPoint, int max) {
		super(position, health, megicPoint, max);
		this.potion = potion;
		this.ammo = ammo;
	}
	
	public void attack (Unit enemy) {
		if (enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			
			ammo = 5;
			power = ran.nextInt(max) + 3;
			
			if (ammo > 0) {				
				boss.setHealth(boss.getHealth() - power);
				boss.setMegicPoint(boss.getMegicPoint() + power / 2);
				ammo --;
			} else {
				System.out.println ("재장전이 필요합니다.");
			}
			
			if (boss.getHealth() <= 0) {
				boss.setHealth(0);
			}
			
			if (power >= 20) {
				String message = String.format("Critical! 보스 좀비에게 치명상을 입혔습니다. \n 보스 체력 : %d", boss.getHealth());
				System.out.println (message);
			}
		}
	}
	
	public void Recovery () {
		if (Human.getMegicPoint() < 100) {
			
		}
	}

}

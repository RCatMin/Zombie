package units;

import interfaces.Enemy;

public class Zombie extends Unit implements Enemy{

	int power;
	
	public Zombie(int position, int health, int max) {
		super(position, health, max);
	}
	
	public void attack (Unit unit) {
		// 좀비의 공력력
		power = ran.nextInt(max);
		
		if (unit instanceof Human) {			
			// 좀비 공격시 플레이어 체력 감소
			unit.setHealth(unit.getHealth() - power);
			// 좀비 공격시 플레이어 마나 보충
			unit.setMegicPoint(unit.getMegicPoint() + power);
			if (unit.getHealth() <= 0) {
				unit.setHealth(0);
			} 
		}
		
		// 좀비 공격력이 0일 때 MISS 아니면 피격 후 남은 체력 출력
		if (power == 0) {
			System.out.println ("좀비가 공격했으나 방어에 성공했습니다.");
		} else {
			String message = String.format("플레이어가 %d의 데미지를 받았습니다. \n 남은 체력 : %d", power, unit.getHealth());
			System.out.println (message);
		}
	}

}

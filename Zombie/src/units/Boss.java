package units;

import java.util.Random;

public class Boss extends Zombie {

	Random ran = new Random();

	public Boss(int position, int health, int max) {
		super(position, health, max);
	}

	public void attack(Unit unit) {

		unit.setHealth(unit.getHealth() - power);
		unit.setMegicPoint(unit.getMegicPoint() + power);

		if (power > 20) {
			String message = String.format("Critical! 플레이어가 %d의 데미지를 받았습니다. \n 남은 체력 : %d", power,
					unit.getHealth());
			System.out.println(message);
		} else {
			String message = String.format("플레이어가 %d의 데미지를 받았습니다. \n 남은 체력 : %d", power, unit.getHealth());
			System.out.println(message);
		}
	}

}

package units;

import interfaces.Enemy;

public class Human extends Unit{
	
	private int power;
	private int ammo;
	private int mediKit;

	public Human(int position, int health, int megicPoint, int ammo, int max, int mediKit) {
		super(position, health, megicPoint, max);
		this.ammo = ammo;
		this.mediKit = mediKit;
	}
	
	public int getAmmo() {
		return ammo;
	}
	
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	
	public void attack (Unit unit) {
		power = ran.nextInt(max) + 3;
		if (unit instanceof Enemy) {
			if (unit instanceof Boss) {
				Boss boss = (Boss) unit;
				
				if (ammo > 0) {				
					boss.setHealth(boss.getHealth() - power);
					boss.setMegicPoint(boss.getMegicPoint() + power / 2);
					setAmmo(getAmmo() - 1);
				} else if (ammo <= 0){
					System.out.println ("재장전이 필요합니다!");
				}
				
				if (boss.getHealth() <= 0) {
					boss.setHealth(0); 
				}
			} else {
				if (ammo > 0) {				
					unit.setHealth(unit.getHealth() - power);
					unit.setMegicPoint(unit.getMegicPoint() + power / 2);
					ammo --;
				} else if (ammo <= 0){
					System.out.println ("재장전이 필요합니다!");
				}
				
				if (unit.getHealth() <= 0) {
					unit.setHealth(0);
				}
			}
			
			if (power >= 20 && ammo > 0) {
				String message = String.format("Critical! 좀비에게 치명상을 입혔습니다. \n 적 체력 : %d", unit.getHealth());
				System.out.println (message);
			} else if (power < 20 && ammo > 0){
				String message = String.format("좀비에게 %d의 데미지를 입혔습니다. \n 적 체력 : %d", power, unit.getHealth());
				System.out.println (message);
			}
		}
	}
	
	public void reload () {
		if (ammo == 5) {
			System.out.println ("이미 재장전된 상태입니다.");
		} else {			
			ammo = 5;
			System.out.println ("탄창 교환 완료");
		}
	}
	
	public void callAirStrike(Unit unit) {
		if (unit instanceof Boss) {
			Boss boss = (Boss) unit;
			
			power = ran.nextInt(max) + 200;
			boss.setHealth(boss.getHealth() - power);
			if (boss.getHealth() <= 0) {
				boss.setHealth(0);
			}
			String message = String.format("폭격 성공! \n 보스 체력 : %d", boss.getHealth());
			System.out.println (message);
		}
	}
	
	public void useMediKit() {
		if (mediKit > 0) {
			setHealth(getHealth() + 100);
			System.out.println("응급처치 키트를 사용하여 플레이어의 체력이" + getHealth() + "이 되었습니다");
			mediKit -= 1;
		} else if (mediKit == 0) {
			System.out.println("모두 사용했습니다.");
		}
	}

	

}

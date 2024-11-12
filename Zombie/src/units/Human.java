package units;

public class Human extends Unit{
	
	int power;
	int ammo;
	int mediKit;

	public Human(int position, int health, int megicPoint, int ammo, int max, int mediKit) {
		super(position, health, megicPoint, max);
		this.ammo = ammo;
		this.mediKit = mediKit;
	}
	
	public void attack (Unit enemy) {
		ammo = 5;
		if (enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			
			power = ran.nextInt(max) + 3;
			
			if (ammo > 0) {				
				boss.setHealth(boss.getHealth() - power);
				boss.setMegicPoint(boss.getMegicPoint() + power / 2);
				ammo --;
			} else if (ammo == 0){
				System.out.println ("재장전이 필요합니다!");
			}
			
			if (boss.getHealth() <= 0) {
				boss.setHealth(0);
			}
			
			if (power >= 20) {
				String message = String.format("Critical! 보스 좀비에게 치명상을 입혔습니다. \n 보스 체력 : %d", boss.getHealth());
				System.out.println (message);
			} else {
				String message = String.format("보스 좀비에게 %d의 데미지를 입혔습니다. \n 보스 체력 : %d", power, boss.getHealth());
				System.out.println (message);
			}
		}
		
		if (enemy instanceof Zombie) {
			Zombie normalZombie = (Zombie) enemy;

			power = ran.nextInt(max) + 3;
			
			if (ammo > 0) {				
				normalZombie.setHealth(normalZombie.getHealth() - power);
				ammo --;
			} else if (ammo == 0){
				System.out.println ("재장전이 필요합니다!");
			}
			
			if (normalZombie.getHealth() <= 0) {
				normalZombie.setHealth(0);
			}
			
			if (power >= 20) {
				String message = String.format("Critical! 좀비에게 치명상을 입혔습니다. \n 좀비 체력 : %d", normalZombie.getHealth());
				System.out.println (message);
			} else {
				String message = String.format("좀비에게 %d의 데미지를 입혔습니다. \n 좀비 체력 : %d", power, normalZombie.getHealth());
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
	
	public void callAirStrike(Unit enemy) {
		if (enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			
			power = ran.nextInt(max) + 200;
			boss.setHealth(boss.getHealth() - power);
			if (boss.getHealth() <= 0) {
				boss.setHealth(0);
			}
			String message = String.format("폭격 성공! \n 보스 체력 : %d", boss.getHealth());
			System.out.println (message);
		}
		
		if (enemy instanceof Zombie) {
			Zombie normalZombie = (Zombie) enemy;
			
			power = ran.nextInt(max) + 200;
			normalZombie.setHealth(normalZombie.getHealth() - power);
			if (normalZombie.getHealth() <= 0) {
				normalZombie.setHealth(0);
			}
			String message = String.format("폭격 성공! \n 좀비 체력 : %d", normalZombie.getHealth());
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

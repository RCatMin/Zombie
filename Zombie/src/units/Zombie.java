package units;

public class Zombie extends Unit{

	int power;
	
	public Zombie(int position, int health, int max) {
		super(position, health, max);
	}
	
	public void attack (Unit Human) {
		// 좀비의 공력력
		power = ran.nextInt(max);
		
		// 좀비 공격시 플레이어 체력 감소
		Human.setHealth(Human.getHealth() - power);
		// 좀비 공격시 플레이어 마나 보충
		Human.setMegicPoint(Human.getMegicPoint() + power);
		if (Human.getHealth() <= 0) {
			Human.setHealth(0);
		}
		
		// 좀비 공격력이 0일 때 MISS 아니면 피격 후 남은 체력 출력
		if (power == 0) {
			System.out.println ("좀비가 공격했으나 방어에 성공했습니다.");
		} else {
			String message = String.format("좀비가 %d의 피해를 입혔습니다. 남은 체력 : %d", power, Human.getHealth());
			System.out.println (message);
		}
	}

}

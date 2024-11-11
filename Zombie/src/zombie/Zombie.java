package zombie;

public class Zombie extends Unit{

	int power;
	
	public Zombie(int position, int health, int max) {
		super(position, health, max);
	}
	
	public void attack (Unit Human) {
		power = ran.nextInt(max);
		
		Human.setHealth(Human.getHealth() - power);
		if (Human.getHealth() <= 0) {
			Human.setHealth(0);
		}
		
		if (power == 0) {
			System.out.println ("좀비가 공격했으나 방어에 성공했습니다.");
		} else {
			String message = String.format("좀비가 %d의 피해를 입혔습니다. 남은 체력 : %d", power, Human.getHealth());
			System.out.println (message);
		}
	}

}

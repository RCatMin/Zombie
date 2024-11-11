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
	
	public void attack (Unit zombie) {
		
	}

}

package zombie;

import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main (String [] args) {
		Scanner scan = new Scanner (System.in);
		Random ran = new Random ();
		
		// 좀비 스폰 위치를 랜덤으로
		int spawnLocation = ran.nextInt(5) + 2;
		
		Human player = new Human (1, 100, 50, 50);
		Zombie normalZombie = new Zombie (spawnLocation, 150, 10);
		Boss boss = new Boss (spawnLocation + 3, 300, 50, 0);
		
		}
	}
}

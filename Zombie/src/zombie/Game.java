package zombie;

import java.util.Scanner;

import units.Boss;
import units.Human;
import units.Zombie;

import java.util.Random;

public class Game {

	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();

	// 좀비 스폰 위치를 랜덤으로
	private int spawnLocation = ran.nextInt(5) + 2;

	// 플레이어 (현 위치, 체력, 마나, 남은 장탄수, 공격력, 응급처치키트)
	private Human player = new Human(1, 100, 50, 5, 50, 3);
	// 좀비 (현 위치, 체력, 공력력)
	private Zombie normalZombie = new Zombie(spawnLocation, 150, 30);
	// 보스 (현 위치, 체력, 공격력)
	private Boss boss = new Boss(spawnLocation + 3, 300, 50);

	private int position = player.getPosition();

	private boolean isRun = true;

	public void run() {
		while (isRun) {
			String message = String.format("현재위치 : %d 체력 : %d 마나 : %d\n앞으로 1칸 이동 (1) / 게임 종료 (2) ", position,
					player.getHealth(), player.getMegicPoint());
			System.out.println(message);

			int select = selectNum("입력하세요.");

			if (select == 1) {
				player.setPosition(++position);
			}

			if (player.getPosition() == normalZombie.getPosition()) {
				fightZombie(normalZombie);
			}

			if (player.getPosition() == boss.getPosition()) {
				fightBoss(boss);
			}

			if (select == 2) {
				System.out.println("게임을 종료합니다.");
				isRun = false;
			}
			
			if (position == 10) {
				System.out.println ("게임 클리어");
				isRun = false;
			}
		}
	}

	private void fightZombie(Zombie normalZombie) {
		System.out.println("좀비와 조우했습니다. 교전을 준비하세요.");

		while (player.getPosition() == normalZombie.getPosition()) {
			System.out.println("1) 공격하기\n2) 재장전\n3) 폭격요청\n4) 구급상자 사용");
			System.out.println("남은 장탄수 : " + player.getAmmo());
			
			int selAction = selectNum("입력하세요");

			if (selAction == 1) {
				player.attack(normalZombie); // 플레이어의 공격 데미지를 저장
				normalZombie.attack(player); // 좀비의 공격 데미지를 저장
			}

			if (selAction == 2) {
				player.reload();
			}

			if (selAction == 3) {
				if (player.getMegicPoint() < 100) {
					System.out.println("마나가 부족해 공습을 요청할 수 없습니다.");
				} else {
					player.callAirStrike(normalZombie);
					player.setMegicPoint(player.getMegicPoint() - 100);
				}
			}

			if (selAction == 4) {
				player.useMediKit();
			}

			if (player.getHealth() <= 0) {
				System.out.println("플레이어가 사망했습니다. \nGAME OVER.");
				break;

			}
			if (normalZombie.getHealth() <= 0) {
				System.out.println("좀비를 사살했습니다.");
				break;
			}
		}
	}

	private void fightBoss(Boss boss) {
		System.out.println("보스와 조우했습니다. 교전을 준비하세요.");

		while (player.getPosition() == boss.getPosition()) {
			System.out.println("1) 공격하기\n2) 재장전\n3) 폭격요청\n4) 구급상자 사용");
			System.out.println("남은 장탄수 : " + player.getAmmo());

			int selAction = selectNum("입력하세요");

			if (selAction == 1) {
				player.attack(boss); // 플레이어의 공격 데미지를 저장
				normalZombie.attack(player); // 좀비의 공격 데미지를 저장
			}

			if (selAction == 2) {
				player.reload();
			}

			if (selAction == 3) {
				if (player.getMegicPoint() < 100) {
					System.out.println("마나가 부족해 공습을 요청할 수 없습니다.");
				} else {
					player.callAirStrike(boss);
					player.setMegicPoint(player.getMegicPoint() - 100);
				}
			}

			if (selAction == 4) {
				player.useMediKit();
			}

			if (player.getHealth() <= 0) {
				System.out.println("플레이어가 사망했습니다. \nGAME OVER. ");
				break;

			}
			if (boss.getHealth() <= 0) {
				System.out.println("보스를 사살했습니다.");
				break;
			}
		}
	}

	private int selectNum(String message) {
		System.out.println(message + " ");
		String input = scan.nextLine();

		int number = -1;
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자로 입력하세요");
		}

		return number;
	}

}

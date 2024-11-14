> # ZOMBIE GAME

자바 다형성 콘솔 게임을 구현

<br>

### 게임 설명
> - 총 10개 칸으로 이루어진 맵에서 앞으로 이동
> - Enemy를 만나면 교전을 시작
> - 마지막 10번 칸에 도달하면 게임이 클리어되며, 그 이전에 일반 좀비와 보스 좀비를 조우하게 됨.
> - 교전 간 장전한 총알이 모두 소진될 경우 재장전을 실시해야 하며, 재장전을 하지 않을 시 공격이 불가함.
> - 스킬로 폭격을 사용할 수 있으며, 이 때 Magic Point가 100 소모됨.
> - 응급처치키트 아이템이 제공되며, 사용 시 플레이어의 체력이 100 회복됨.
<br><br>

### Class Diagram
![클래스다이어그램](클래스 다이어그램 주소 (추후 수정예정))

<br><br>

### Demo
<img src ="데모 주소" width="400">
<br>
<img src ="데모 주소" width="400">

<br><br>

### Tree
```
📦src
 ┣ 📂interfaces
 ┃ ┗ 📜Enemy.java
 ┣ 📂units
 ┃ ┣ 📜Boss.java
 ┃ ┣ 📜Human.java
 ┃ ┣ 📜Unit.java
 ┃ ┗ 📜Zombie.java
 ┗  📂zombie
   ┣ 📜Game.java
   ┗ 📜Main.java

```

public class monsterSetup {
 private int slime1HP;
 private String weapon;
 public monsterSetup(Game game) {
  slime1HP = 10;
  weapon = "unarmed";
  game.setSlime1HP(slime1HP);
 }

 public int getHP() {
  return slime1HP;
 }

 public void setHP(int hp) {
  slime1HP = hp;
 }
}
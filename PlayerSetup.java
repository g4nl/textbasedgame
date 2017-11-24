public class PlayerSetup {
 private int playerHP;
 private String weapon;
 private Game game;
 public PlayerSetup(Game game) {
  playerHP = 15;
  weapon = "unarmed";
  this.game = game;
  game.setPlayerHP(playerHP);
  game.setWeapon(weapon);
 }

 public void setWeapon(String weapon) {
  this.weapon = weapon;
  game.setWeapon(weapon);
 }

 public String getWeapon() {
  return weapon;
 }

 public int getHP() {
  return playerHP;
 }

 public void setHP(int hp) {
  playerHP = hp;
 }
}
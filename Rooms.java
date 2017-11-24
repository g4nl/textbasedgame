/**
 * Write a description of class Rooms here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rooms {
 private String position;
 private String mainText;
 private String choice1;
 private String choice2;
 private String choice3;
 private String choice4;
 private String choice5;
 public Rooms(String position, String mainText, String choice1, String choice2, String choice3, String choice4, String choice5) {
  this.position = position;
  this.mainText = mainText;
  this.choice1 = choice1;
  this.choice2 = choice2;
  this.choice3 = choice3;
  this.choice4 = choice4;
  this.choice5 = choice5;
 }
 public String getPosition() {
  return position;
 }
 public String getText() {
  return mainText;
 }
 public String getC1() {
  return choice1;
 }
 public String getC2() {
  return choice2;
 }
 public String getC3() {
  return choice3;
 }
 public String getC4() {
  return choice4;
 }
 public String getC5() {
  return choice5;
 }
}
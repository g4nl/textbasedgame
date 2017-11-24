import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;




public class Game {
 JFrame window;
 Container con;
 JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, quitPanel;
 JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, quitLabel;
 Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
 Font normalFont = new Font("Times New Roman", Font.PLAIN, 24);
 JButton startButton, choice1, choice2, choice3, choice4, choice5, quitButton;
 JTextArea mainTextArea;
 private int playerHP, slime1HP;
 private int goo, torch, sword;
 String weapon, position;
 TitleScreenHandler tsHandler = new TitleScreenHandler();
 ChoiceHandler choiceHandler = new ChoiceHandler();
 private PlayerSetup setup;
 private monsterSetup monster;
 private Rooms forest, forestSwordTaken, credits, end, investigateForest, investigateForestSwordTaken, forestDirections, takeSword, lake, investigateLake, lakeDirections, denseForest, investigateDenseForest, denseForestDirections, shrine, investigateShrine, prayShrine, shrineDirections, cave, investigateCave, caveDirections, caveOldMan, caveOldManSwordTaken, caveRoom1, caveRoom2, caveRoom3, caveRoom3Fight, PlayerAttack, slime1Attack, win, lose, caveRoom4, caveRoom5, road;
 private Rooms currentRoom;

 public Game() {
  window = new JFrame();
  window.setSize(800, 600);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  window.getContentPane().setBackground(Color.black);
  window.setLayout(null);
  con = window.getContentPane();

  titleNamePanel = new JPanel();
  titleNamePanel.setBounds(100, 100, 600, 150);
  titleNamePanel.setBackground(Color.black);
  titleNameLabel = new JLabel("A DarkTale");
  titleNameLabel.setForeground(Color.white);
  titleNameLabel.setFont(titleFont);

  startButtonPanel = new JPanel();
  startButtonPanel.setBounds(300, 400, 200, 100);
  startButtonPanel.setBackground(Color.black);

  startButton = new JButton("START");
  startButton.setBackground(Color.black);
  startButton.setForeground(Color.white);
  startButton.setFont(normalFont);
  startButton.addActionListener(tsHandler);
  startButton.setFocusPainted(false);

  titleNamePanel.add(titleNameLabel);
  startButtonPanel.add(startButton);

  forest = new Rooms("forest", "You've awoken in the middle of a forest,\nit is quiet and peaceful. You can hear the birds\nchirping and the wind rustling through the trees.\n\nYou wonder where you are...", "INVESTIGATE", "", "", "", "GO");
  investigateForest = new Rooms("investigateForest", "Large trees surround you,\nthe grass stands tall with a variety\nof wild flowers growing through it.\n\nYou notice an old sword stuck in the ground.", "TAKE SWORD", "", "", "", "BACK");
  investigateForestSwordTaken = new Rooms("investigateForestSwordTaken", "Large trees surround you,\nthe grass stands tall with a variety\nof wild flowers growing through it.", "", "", "", "", "BACK");
  takeSword = new Rooms("takeSword", "Tun Tun Tun Tuuun! You obtained an old sword!\n(Added to inventory).", "", "", "", "", "BACK");
  forestDirections = new Rooms("forestDirections", "Where to?", "NORTH", "EAST", "SOUTH", "WEST", "BACK");
  forestSwordTaken = new Rooms("forestSwordTaken", "You're in a forrest", "INVESTIGATE", "", "", "", "GO");
  cave = new Rooms("cave", "You stand before an ancient cave,\ncovered with strange symbols.", "INVESTIGATE", "", "", "", "GO");
  investigateCave = new Rooms("investigateCave", "You take a closer look at the symbols.\nthey seem to depict a story of sorts...\nbut they're too faded to be sure.", "", "", "", "", "BACK");
  caveDirections = new Rooms("caveDirections", "Where to?", "NORTH", "SOUTH", "", "", "BACK");
  caveOldMan = new Rooms("caveOldMan", "Ho there kiddo!\nIt's dangerous to enter this cave without a sword!\nIt is filled with monsters and other dangerous things.\n\nI can't let you pass without one!", "", "", "", "", "BACK");
  caveOldManSwordTaken = new Rooms("caveOldManSwordTaken", "Ho there kiddo!\nIt's dangerous to enter this cave without a sword!\nIt is filled with monsters a... HUH?!\nYou have found yourself a sword?! Well go ahead then,\nHave fun in there!.. OH almost forgot, take this torch.\nIt can get pretty dark in a cave.\n\n(Added to inventory).", "ENTER CAVE", "", "", "", "BACK");
  caveRoom1 = new Rooms("caveRoom1", "You're inside the cave. It is dark.\nYou light the torch.", "PROCEED", "", "", "", "RESTART DUNGEON");
  caveRoom2 = new Rooms("caveRoom2", "The torch illuminates the wall.\nYou hear noises up ahead...", "PROCEED", "", "", "", "RESTART DUNGEON");
  caveRoom3 = new Rooms("caveRoom3", "You've encountered a slime!", "FIGHT", "RUN", "", "", "RESTART DUNGEON");
  caveRoom3Fight = new Rooms("caveRoom3Fight", "slime HP: slime1HP\n\nWhat do you do?", "ATTACK", "RUN", "", "", "");
  win = new Rooms("win", "You defeated the slime!\n\nThe slime dropped goo.\n\n(Added to inventory).", "PROCEED", "", "", "", "");
  lose = new Rooms("lose", "YOU DIED\n\nReally... from a slime?!", "RETRY", "", "", "", "");
  caveRoom4 = new Rooms("caveRoom4", "The torch illuminates the wall.\nYou see the remains of the slime splattered\nagainst the wall..", "PROCEED", "", "", "", "RESTART DUNGEON");
  caveRoom5 = new Rooms("caveRoom5", "The cave becomes lighter.\nYou see an opening up ahead..", "PROCEED", "", "", "", "RESTART DUNGEON");
  road = new Rooms("road", "Ah you made it out! How'd I get here?\nI walked around the cave ofcourse!..\nAnyhow, glad to see you're still alive.\nTake this!\nYou got 5 coins.\n\n(Added to inventory).\nEND OF GAME).", "REPLAY", "", "", "", "CREDITS");
  lake = new Rooms("lake", "You stand before a lake", "INVESTIGATE", "", "", "", "GO");
  lakeDirections = new Rooms("lakeDirections", "Where to?", "WEST", "", "", "", "BACK");
  investigateLake = new Rooms("investigateLake", "The lake is surrounded by trees.\nIt is quiet and peaceful.", "", "", "", "", "BACK");
  denseForest = new Rooms("denseForest", "You enter a dense part of the forest", "INVESTIGATE", "", "", "", "GO");
  investigateDenseForest = new Rooms("investigateDenseForest", "The trees are dense,\ncasting a thick shadow on the ground.\nThere is no way through.", "", "", "", "", "BACK");
  denseForestDirections = new Rooms("denseForestDirections", "Where to?", "NORTH", "", "", "", "BACK");
  shrine = new Rooms("shrine", "A large shrine made of stone\nstands before you, depicting a deity.", "INVESTIGATE", "", "", "", "GO");
  investigateShrine = new Rooms("investigateShrine", "You notice that the shrine is old and weathered.\nIt looks abandoned. You can see the statue\nof a female deity.\n\nUnderneath the statue you can read the text:\n'Ygeía, the giver of life'", "PRAY", "", "", "", "BACK");
  prayShrine = new Rooms("prayShrine", "You kneel before her. A bright aurora appears,\nyou feel replenished.\n\nNothing else happens...", "", "", "", "", "BACK");
  shrineDirections = new Rooms("shrineDirections", "Where to?", "EAST", "", "", "", "BACK");
  credits = new Rooms("credits", "Thank you for playing the demo of:\nA Dark Tale\n\nThis game was created by:\nRicky Muijters", "DONATE", "", "", "", "REPLAY");
  end = new Rooms("end", "Hey! glad to see you you liked the demo\nand want to donate!\n\nSoon a patreon and kickstarter will be\nlaunched, stay tuned!", "", "", "", "", "BACK");
  currentRoom = forest;



  con.add(titleNamePanel);
  con.add(startButtonPanel);
  window.setVisible(true);
 }

 /**
  * Create all the rooms and link their exits together.
  */
 public void createGameScreen() {
  {
   titleNamePanel.setVisible(false);
   startButtonPanel.setVisible(false);

   mainTextPanel = new JPanel();
   mainTextPanel.setBounds(100, 100, 600, 250);
   mainTextPanel.setBackground(Color.black);
   con.add(mainTextPanel);

   mainTextArea = new JTextArea("Insert text Here");
   mainTextArea.setBounds(100, 100, 600, 250);
   mainTextArea.setBackground(Color.black);
   mainTextArea.setForeground(Color.white);
   mainTextArea.setFont(normalFont);
   mainTextArea.setLineWrap(true);
   mainTextPanel.add(mainTextArea);

   choiceButtonPanel = new JPanel();
   choiceButtonPanel.setBounds(250, 350, 300, 150);
   choiceButtonPanel.setBackground(Color.black);
   choiceButtonPanel.setLayout(new GridLayout(5, 1));
   con.add(choiceButtonPanel);

   choice1 = new JButton("one");
   choice1.setBackground(Color.black);
   choice1.setForeground(Color.white);
   choice1.setFont(normalFont);
   choiceButtonPanel.add(choice1);
   choice1.setFocusPainted(false);
   choice1.addActionListener(choiceHandler);
   choice1.setActionCommand("c1");

   choice2 = new JButton("two");
   choice2.setBackground(Color.black);
   choice2.setForeground(Color.white);
   choice2.setFont(normalFont);
   choiceButtonPanel.add(choice2);
   choice2.setFocusPainted(false);
   choice2.addActionListener(choiceHandler);
   choice2.setActionCommand("c2");

   choice3 = new JButton("three");
   choice3.setBackground(Color.black);
   choice3.setForeground(Color.white);
   choice3.setFont(normalFont);
   choiceButtonPanel.add(choice3);
   choice3.setFocusPainted(false);
   choice3.addActionListener(choiceHandler);
   choice3.setActionCommand("c3");

   choice4 = new JButton("four");
   choice4.setBackground(Color.black);
   choice4.setForeground(Color.white);
   choice4.setFont(normalFont);
   choiceButtonPanel.add(choice4);
   choice4.setFocusPainted(false);
   choice4.addActionListener(choiceHandler);
   choice4.setActionCommand("c4");

   choice5 = new JButton("five");
   choice5.setBackground(Color.black);
   choice5.setForeground(Color.white);
   choice5.setFont(normalFont);
   choiceButtonPanel.add(choice5);
   choice5.setFocusPainted(false);
   choice5.addActionListener(choiceHandler);
   choice5.setActionCommand("c5");

   playerPanel = new JPanel();
   playerPanel.setBounds(100, 15, 600, 50);
   playerPanel.setBackground(Color.black);
   playerPanel.setLayout(new GridLayout(1, 4));
   con.add(playerPanel);
   hpLabel = new JLabel("HP:");
   hpLabel.setFont(normalFont);
   hpLabel.setForeground(Color.white);
   playerPanel.add(hpLabel);

   hpLabelNumber = new JLabel("");
   hpLabelNumber.setFont(normalFont);
   hpLabelNumber.setForeground(Color.white);
   playerPanel.add(hpLabelNumber);

   weaponLabel = new JLabel("WEAPON:");
   weaponLabel.setFont(normalFont);
   weaponLabel.setForeground(Color.white);
   playerPanel.add(weaponLabel);

   weaponLabelName = new JLabel();
   weaponLabelName.setFont(normalFont);
   weaponLabelName.setForeground(Color.white);
   playerPanel.add(weaponLabelName);

   setup = new PlayerSetup(this);
   monster = new monsterSetup(this);
   getRooms();
  }
 }

 public void monsterSetup() {
  slime1HP = 10;
 }
 public class TitleScreenHandler implements ActionListener {
  public void actionPerformed(ActionEvent event) {
   createGameScreen();
  }
 }
 public class ChoiceHandler implements ActionListener {
  public void actionPerformed(ActionEvent event) {
   String yourChoice = event.getActionCommand();

   switch (position) {
    case "forest":
     switch (yourChoice) {
      case "c1":
       if (sword == 1) {
        currentRoom = investigateForestSwordTaken;
        getRooms();

       } else {
        currentRoom = investigateForest;
        getRooms();

       }

       break;
      case "c5":
       currentRoom = forestDirections;
       getRooms();

       break;
     }
     break;
    case "forestSwordTaken":
     switch (yourChoice) {
      case "c1":
       if (sword == 1) {
        currentRoom = investigateForestSwordTaken;
        getRooms();

       } else {
        currentRoom = investigateForest;
        getRooms();

       }

       break;
      case "c5":
       currentRoom = forestDirections;
       getRooms();

       break;
     }
     break;
    case "investigateForest":
     switch (yourChoice) {
      case "c1":
       currentRoom = takeSword;
       getRooms();
       break;
      case "c5":
       currentRoom = forestSwordTaken;
       getRooms();

       break;
     }
    case "investigateForestSwordTaken":
     switch (yourChoice) {
      case "c5":
       currentRoom = forestSwordTaken;
       getRooms();

       break;
     }
     break;
    case "takeSword":
     switch (yourChoice) {
      case "c5":
       currentRoom = forestSwordTaken;
       getRooms();

       break;
     }
     break;
    case "forestDirections":
     switch (yourChoice) {
      case "c1":
       currentRoom = cave;
       getRooms();

       break;
      case "c2":
       currentRoom = lake;
       getRooms();

       break;
      case "c3":
       currentRoom = denseForest;
       getRooms();

       break;
      case "c4":
       currentRoom = shrine;
       getRooms();

       break;
      case "c5":
       currentRoom = forestSwordTaken;
       getRooms();

       break;
     }
     break;
    case "investigateCave":
     switch (yourChoice) {
      case "c5":
       currentRoom = cave;
       getRooms();

       break;

     }
     break;
    case "cave":
     switch (yourChoice) {
      case "c1":
       currentRoom = investigateCave;
       getRooms();

       break;
      case "c5":
       currentRoom = caveDirections;
       getRooms();

       break;
     }
     break;
    case "caveOldMan":
     switch (yourChoice) {
      case "c5":
       currentRoom = cave;
       getRooms();

       break;
     }
     break;
    case "caveOldManSwordTaken":
     switch (yourChoice) {
      case "c1":
       currentRoom = caveRoom1;
       getRooms();

       break;
      case "c5":
       currentRoom = cave;
       getRooms();

       break;
     }
     break;
    case "caveRoom1":
     switch (yourChoice) {
      case "c1":
       if (goo == 1) {
        currentRoom = caveRoom4;
        getRooms();

       } else {
        currentRoom = caveRoom2;
        getRooms();

       }
       break;
      case "c5":
       currentRoom = caveRoom1;
       getRooms();

       break;
     }
     break;
    case "caveRoom2":
     switch (yourChoice) {
      case "c1":
       currentRoom = caveRoom3;
       getRooms();

       break;
      case "c5":
       currentRoom = caveRoom1;
       getRooms();

       break;
     }
     break;
    case "caveRoom3":
     switch (yourChoice) {
      case "c1":
       currentRoom = caveRoom3Fight;
       getRooms();

       break;
      case "c2":
       currentRoom = caveRoom2;
       getRooms();

       break;
      case "c5":
       currentRoom = caveRoom1;
       getRooms();

       break;
     }
     break;
    case "caveRoom3Fight":
     switch (yourChoice) {
      case "c1":
       playerAttack();
       break;
      case "c2":
       currentRoom = caveRoom2;
       getRooms();

       break;
     }
     break;
    case "playerAttack":
     switch (yourChoice) {
      case "c1":
       if (monster.getHP() < 1) {
        currentRoom = win;
        getRooms();

       } else {
        slime1Attack();
       }
       break;
     }
     break;
    case "slime1Attack":
     switch (yourChoice) {
      case "c1":
       if (setup.getHP() < 1) {
        currentRoom = lose;
        getRooms();

       } else {
        currentRoom = caveRoom3Fight;
        getRooms();

       }
       break;
     }
     break;
    case "win":
     switch (yourChoice) {
      case "c1":
       currentRoom = caveRoom4;
       getRooms();

       break;
      case "c5":
       currentRoom = caveRoom1;
       getRooms();

       break;
     }
     break;
    case "lose":
     switch (yourChoice) {
      case "c1":
       currentRoom = caveRoom1;
       getRooms();

       if (setup.getHP() < 15) {
        setPlayerHP(15);
        setup.setHP(15);
        setSlime1HP(10);
        monster.setHP(10);
       }
       if (monster.getHP() < 10) {
        setSlime1HP(10);
        monster.setHP(10);
       }

       break;
     }
     break;
    case "caveRoom4":
     switch (yourChoice) {
      case "c1":
       currentRoom = caveRoom5;
       getRooms();

       break;
      case "c5":
       currentRoom = caveRoom1;
       getRooms();

       break;
     }
     break;
    case "caveRoom5":
     switch (yourChoice) {
      case "c1":
       currentRoom = road;
       getRooms();

       break;
      case "c5":
       currentRoom = caveRoom1;
       getRooms();

       break;
     }
     break;
    case "road":
     switch (yourChoice) {
      case "c5":
       currentRoom = credits;
       getRooms();
       break;
      case "c1":
       currentRoom = forest;
       getRooms();
       setPlayerHP(15);
       setup.setHP(15);
       setSlime1HP(10);
       monster.setHP(10);
       goo = 0;
       sword = 0;
       setup.setWeapon("unarmed");
       torch = 0;
       break;
     }
     break;
    case "credits":
     switch (yourChoice) {
      case "c1":
       currentRoom = end;
       getRooms();
       break;
      case "c5":
       currentRoom = forest;
       getRooms();
       setPlayerHP(15);
       setup.setHP(15);
       setSlime1HP(10);
       monster.setHP(10);
       goo = 0;
       sword = 0;
       setup.setWeapon("unarmed");
       torch = 0;
       break;
     }
     break;
    case "end":
     switch (yourChoice) {
      case "c5":
       currentRoom = credits;
       getRooms();
       break;
     }
     break;

    case "caveDirections":
     switch (yourChoice) {
      case "c1":
       if (sword == 1) {
        currentRoom = caveOldManSwordTaken;
        getRooms();

       } else {
        currentRoom = caveOldMan;
        getRooms();

       }


       break;
      case "c2":
       currentRoom = forest;
       getRooms();

       break;
      case "c3":
       currentRoom = caveDirections;
       getRooms();

       break;
      case "c4":
       currentRoom = caveDirections;
       getRooms();

       break;
      case "c5":
       currentRoom = cave;
       getRooms();

       break;

     }
     break;
    case "lake":
     switch (yourChoice) {
      case "c1":
       currentRoom = investigateLake;
       getRooms();

       break;
      case "c5":
       currentRoom = lakeDirections;
       getRooms();

       break;
     }
     break;
    case "investigateLake":
     switch (yourChoice) {
      case "c5":
       currentRoom = lake;
       getRooms();

       break;
     }
     break;
    case "lakeDirections":
     switch (yourChoice) {
      case "c1":
       currentRoom = forest;
       getRooms();

       break;
      case "c5":
       currentRoom = lake;
       getRooms();

       break;
     }
     break;
    case "denseForest":
     switch (yourChoice) {
      case "c1":
       currentRoom = investigateDenseForest;
       getRooms();

       break;
      case "c5":
       currentRoom = denseForestDirections;
       getRooms();

       break;
     }
     break;
    case "investigateDenseForest":
     switch (yourChoice) {
      case "c5":
       currentRoom = denseForest;
       getRooms();

       break;
     }
     break;
    case "denseForestDirections":
     switch (yourChoice) {
      case "c1":
       currentRoom = forest;
       getRooms();

       break;
      case "c5":
       currentRoom = denseForest;
       getRooms();

       break;
     }
     break;
    case "shrine":
     switch (yourChoice) {
      case "c1":
       currentRoom = investigateShrine;
       getRooms();

       break;
      case "c5":
       currentRoom = shrineDirections;
       getRooms();

       break;
     }
     break;
    case "investigateShrine":
     switch (yourChoice) {
      case "c1":
       currentRoom = prayShrine;
       getRooms();

       break;
      case "c5":
       currentRoom = shrine;
       getRooms();

       break;
     }
     break;
    case "prayShrine":
     switch (yourChoice) {
      case "c5":
       currentRoom = shrine;
       getRooms();

       break;
     }
     break;
    case "shrineDirections":
     switch (yourChoice) {
      case "c1":
       currentRoom = forest;
       getRooms();

       break;
      case "c5":
       currentRoom = shrine;
       getRooms();

       break;
     }
   }
  }
 }

 public void getRooms() {
  position = currentRoom.getPosition();
  mainTextArea.setText(currentRoom.getText().replaceAll("slime1HP", "" + monster.getHP()));
  choice1.setText(currentRoom.getC1());
  choice2.setText(currentRoom.getC2());
  choice3.setText(currentRoom.getC3());
  choice4.setText(currentRoom.getC4());
  choice5.setText(currentRoom.getC5());
  if (position == "takeSword") {
   sword = 1;
   setup.setWeapon("sword");
  }
  if (position == "caveOldManSwordTaken") {
   torch = 1;
  }
  if (position == "win") {
   goo = 1;
  }
 }

 public void playerAttack() {
  position = "playerAttack";

  int playerDamage = 2;

  if (setup.getWeapon().equals("sword")) {
   playerDamage = new java.util.Random().nextInt(6);
  } else if (setup.getWeapon().equals("longSword")) {
   playerDamage = new java.util.Random().nextInt(11);
  }

  mainTextArea.setText("You attacked and dealed " + playerDamage + " damage!");

  monster.setHP(monster.getHP() - playerDamage);

  choice1.setText("PROCEED");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");
  choice5.setText("");
 }
 public void slime1Attack() {
  position = "slime1Attack";

  int monsterDamage = 2;

  monsterDamage = new java.util.Random().nextInt(4);

  mainTextArea.setText("The slime attacked and dealed " + monsterDamage + " damage!");

  setup.setHP(setup.getHP() - monsterDamage);
  hpLabelNumber.setText("" + setup.getHP());

  choice1.setText("PROCEED");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");
  choice5.setText("");
 }
 public void setPlayerHP(int playerHP) {
  hpLabelNumber.setText("" + playerHP);
 }
 public void setSlime1HP(int slime1HP) {
  this.slime1HP = slime1HP;
 }
 public void setWeapon(String weapon) {
  weaponLabelName.setText(weapon);
 }
 public void MainTextPanel(String MainText) {
  mainTextArea.setText(MainText);
 }

}
/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/

public class Nerd extends Character {
  public Nerd() {
    _name = "Linus Snowden";
    _hp = 100;
    _strength = (int) (10 + 25 * Math.random());
    _defence = 180;
    _attack = 0.5;
    _gauge = 0;
  }

  public Nerd( String name ) {
    this();
    _name = name;
  }

  public void special(Character enemy) {
    if (getLevel() > 0) {
      int multiplier = 0;
      switch (getLevel()) {
        case 3:
          multiplier = 10;
          break;
        case 1:
			multiplier = -10;
			break;
		}
		
      int modifier = (int) (multiplier * Math.random() + 1);
      _strength = enemy.getStrength() + modifier;
      _defence = enemy.getDefence() + modifier;
      _attack = enemy.getAttack() + ((int) modifier * 0.05);
      System.out.println("Thou hast taken on the form thy nemesis!");
      _gauge = 0;
      _specialized = true;
    }
  }

  public void normal() {
    _specialized = false;
    _strength = (int) (10 + 25 * Math.random());
    _defence = 180;
    _attack = 0.5;
  }

  public String about() {
    return "Nerd";
  }
}

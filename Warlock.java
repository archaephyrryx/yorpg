/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/
 
public class Warlock extends Character {

  private int _antiStrength;

  public Warlock() {
    _name = "Zelda Hyrule";
    _hp = 220;
    _strength = 70;
    _defence = 50;
    _attack = 0.5;
    _gauge = 0;
    _antiStrength = 0;
  }

  public Warlock(String name) {
    this();
    _name = name;
  }

  public void special(Character enemy) {
    if (getLevel() != 0) {
      switch (getLevel()) {
	case 3: // Third-level special ability
          enemy.lowerStrength(9);
          _strength -= 9;
          _defence += 18;
	  break;
	case 2: // Second-level special
          enemy.lowerStrength(6);
          _strength -= 6;
          _defence += 12;
	  break;
	case 1: // First-level special
          enemy.lowerStrength(3);
          _strength -= 3;
          _defence += 6;
	  break;
      }
    }
  }

  public void normal() {
    _gauge = 0;
    _strength += ((70 - _strength)/2);
    _defence -= (70 - _strength);
  }

  public int attack( Character istic ) {
    super();
  }

  public String about() {
    return "The warlock, spoken of in somber tones\n" +
           "He draws his powers dark from ancient bones.\n" +
           "Corrupted magic is his chosen art\n" +
           "And drains the strength from his opponent's heart,\n" +
           "Though his own strength shall lower just as much\n" +
           "For tainted magic leaves a tainted touch.\n" +
           "His loss and foe's loss are each added back\n" +
           "To give his shield twice what his sword may lack.";
  }
}

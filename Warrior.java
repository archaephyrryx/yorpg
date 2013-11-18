/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/

public class Warrior extends Character {

  public Warrior() { 
      _name = "Handscio Norris"; /* Hwalker, Geatland Ranger */
    _hp = 125;
    _strength = 100;
    _defence = 40;
    _attack = 0.4;
    _gauge = 0;
  }

  public Warrior( String name ) {
    this();
    _name = name;
  }

  public void special(Character enemy) {
    if (getLevel() != 0) {
      _defence = 10; 
      switch (getLevel()) {
	case 3: /* Third-level special ability */
	  _attack = 2.0;
	  _hp += 80;
	  break;
	case 2: /* Second-level special */
	  _attack = 1.5;
	  _hp += 40;
	  break;
	case 1: /* First-level special */
	  _attack = 1.0;
	  _hp += 20;
	  break;
      }
      _specialized = true;
    }
  }

  public void normal() {
    if (_specialized) {
      _gauge = 0;
      _attack = 0.4;
      _defence = 40; 
      _specialized = false;
    }
  }

  public String about() {
    return "The warrior's blood-lust knows no bound;\n" +
           "His strength can best most any man's around.\n" +
	   "His greatest tool is that, when in a fight\n" +
	   "His concentration may increase his might.\n" +
	   "And if he toss aside his sturdy shield\n" +
	   "His vorpal blade two-handed he may wield.\n" +
	   "When in the midst of battle, pain is gone;\n" +
	   "His injuries ignored, he battles on.\n" +
	   "His life-force rises when he wounds his foe\n" +
	   "Yet still cannot survive a fatal blow.";

  }
}

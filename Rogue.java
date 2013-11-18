// Nicholas Romanoff, Peter Duchovni, & Philipp Steinmann
// Period Nine
// Homework #24
// November 17th, 2013
 
public class Rogue extends Character {

  private int _antiDefence;

  public Rogue() {
    _name = "Rennac Seethe";
    _hp = 150;
    _strength = 80;
    _defence = 30;
    _attack = 0.7;
    _gauge = 0;
    _antiDefence = 0;
  }

  public Rogue(String name) {
    this();
    _name = name;
  }

  public void special() {
    if (getLevel() != 0) {
      switch (getLevel()) {
	case 3: // Third-level special ability
	  _hp += 30;
          _antiDefence = 6;
	  break;
	case 2: // Second-level special
	  _hp += 20;
          _antiDefence = 4;
	  break;
	case 1: // First-level special
	  _hp += 10;
          _antiDefence = 2;
	  break;
      }
    }
  }

  public void normal() {
    _gauge = 0;
    _antiDefence = 0;
  }

  public int attack( Character istic ) {
    istic.lowerDefence(_antiDefence);
    super();
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

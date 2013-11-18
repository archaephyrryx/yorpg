/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/
 
public class Rogue extends Character {

  private int _mana;

  public Rogue() {
    _name = "Rennac Seethe";
    _hp = 150;
    _strength = 80;
    _defence = 30;
    _attack = 0.7;
    _gauge = 0;
    _mana = 0;
  }

  public Rogue(String name) {
    this();
    _name = name;
  }

  public int getMana() { return _mana; }

  public void special(Character enemy) {
    if (getLevel() != 0) {
      switch (getLevel()) {
	case 3: // Third-level special ability
	  _hp += 30;
          _mana = 6;
	  break;
	case 2: // Second-level special
	  _hp += 20;
          _mana = 4;
	  break;
	case 1: // First-level special
	  _hp += 10;
          _mana = 2;
	  break;
      }
      _strength -= (_mana * 1.5);
    }
  }

  public void normal() {
    _gauge = 0;
    _mana = 0;
    _strength = 80;
  }

  public int attack( Character istic ) {
    int damage;
    damage = ((int) (_strength * _attack)) - istic.getDefence();
    damage = (damage < 0) ? 0 : damage;
    istic.lowerHp(damage);
    istic.lowerDefence(_mana);
    return damage;
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

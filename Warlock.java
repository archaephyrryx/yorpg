/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/
 
public class Warlock extends Character {

  private int _mana;

  public Warlock() {
    _name = "Zelda Hyrule";
    _hp = 220;
    _strength = 70;
    _defence = 50;
    _attack = 0.5;
    _gauge = 0;
    _mana = 0;
  }

  public Warlock(String name) {
    this();
    _name = name;
  }

  public int getMana() { return _mana; }

  public void special(Character enemy) {
    if (getLevel() != 0) {
      switch (getLevel()) {
	case 3: // Third-level special ability
	  _hp -= 20;
          _mana = 9;
	  break;
	case 2: // Second-level special
	  _hp -= 15;
          _mana = 6;
	  break;
	case 1: // First-level special
	  _hp -= 10;
          _mana = 3;
	  break;
      }
      System.out.println("HP has been decreased to: " + _hp);
      System.out.println("The enemy's Strength will be decreased by: " + _mana);
    }
  }

  public void normal() {
    _gauge = 0;
    _mana = 0;
  }

  public int attack( Character istic ) {
    istic.lowerStrength(_mana);
    int damage;
    damage = ((int) (_strength * _attack)) - istic.getDefence();
    damage = (damage < 0) ? 0 : damage;
    istic.lowerHp(damage);
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

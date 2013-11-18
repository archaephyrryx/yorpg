/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/
 
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

  public int getAntiDefence() { return _antiDefence; }

  public void special(Character enemy) {
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
    return "The silent stealth that nimble rogues possess\n" +
           "Enables them to battle with prowess.\n" +
           "With quick and unseen jabs of poisoned knife\n" +
           "He weakens foe's defence and saps their life.\n" +
	   "And if he bides his time and times his lunge\n" +
	   "More deeply shall his fatal dagger plunge.";
  }

    public static void main( String[] args ) {
	Rogue war = new Rogue();
	Monster mon = new Monster();
	System.out.println(mon.getHp());
	System.out.println(mon.getDefence());
	war.attack(mon);
	System.out.println(mon.getHp());
	System.out.println(mon.getDefence());
	war.increment();
	war.special(mon);
	war.attack(mon);
	System.out.println(mon.getHp());
	System.out.println(mon.getDefence());
    }
}

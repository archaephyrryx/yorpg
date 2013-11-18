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
	  _hp -= 40;
	  enemy.lowerDefence(6);
	  break;
	case 2: // Second-level special
	  _hp -= 20;
	  enemy.lowerDefence(4);
	  break;
	case 1: // First-level special
	  enemy.lowerDefence(2);
	  break;
      }
      System.out.println("HP: " + _hp);
      System.out.println("Enemy's Defence: " + enemy.getDefence());
    }
  }

  public void normal() {
    _gauge = 0;
  }

  public String about() {
    return "The silent stealth that nimble rogues possess\n" +
           "Enables them to battle with prowess.\n" +
           "With quick and unseen jabs of poisoned knife\n" +
           "He weakens foe's defence and saps their life.\n" +
	   "And if he bides his time and times his lunge\n" +
	   "More deeply shall his fatal dagger plunge.\n" +
	   "Yet rogues by poison are affected,\n" +
	   "Injured, as the one injected.";
  }
}

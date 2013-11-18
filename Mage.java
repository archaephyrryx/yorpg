/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/

public class Mage extends Character {
  public Mage() {
    _name = "Canned Elf";
    _hp = 200; 
    _strength = 40;
    _defence = 20;
    _attack = 1.0;
    _gauge = 0;
  }

  public Mage( String name ) {
    this();
    _name = name;
  }

  public void special(Character enemy) {
    if (getLevel() != 0) {
      int d20 = (int) (Math.random() * 20 + 1);
      System.out.println("The die is cast: " + d20);

      _attack = 0.05 * d20;
      switch (getLevel()) {
	case 3: /* Third-level special ability */
	  _hp += 15 * d20;
	  break;
	case 2: /* Second-level special */
	  _hp += 10 * d20;
	  break;
	case 1: /* First-level special */
	  _hp += 5 * d20;
	  break;
      }
      _specialized = true;

      System.out.printf("New Attack Modifier: %.2f\n", _attack);
      System.out.println("New HP: " + _hp);


    }
  }

  public void normal() {
    if (_specialized) {
      int d20 = (int) (_attack / 0.05);
      _gauge = 0;
      _attack = 1.0;
      if (_hp > 200) {
        _hp /= 2; 
        _hp += 100; 
      }
      _specialized = false;
    }
  }

  public String about() {
    return "The arcane wisdom of the practiced mage\n" +
	   "Eschews a sword, and reads a spell-book's page.\n" +
	   "His magic spell doth cause his health to rise\n" +
	   "Though chance dictates the value of this prize.\n" +
	   "As haste makes waste, each second he should wait\n" +
	   "Will grant a better boon from fickle Fate.\n" +
	   "But he must trade his might to gain this gift\n" +
	   "And like his vim, his vigor too shall shift.\n" +
	   "This heightened health, however, shall decay\n" +
	   "To what 'twould be on any other day." ;
  }
}

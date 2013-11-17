// Peter Duchovni
// Period 9
// HW 24
// November 14, 2013
 
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
  public void special() {
    int d20 = ((int) Math.random() * 20 + 1);

    if (_gauge >= LEVELS[2]) { /* Third-level special ability */
      _attack = 0.05 * d20;
      _hp += 40 * d20 - 200; 
    } else if (_gauge >= LEVELS[1]) { /* Second-level special */
      _attack = 0.05 * d20;
      _hp += 20 * d20 - 100; 
    } else if (_gauge >= LEVELS[0]) { /* First-level special */
      _attack = 0.05 * d20;
      _hp += 10 * d20 - 50;
    }
    _gauge = 0;
    _specialized = true;
  }

  public void normal() {
    int d20 = (int) (_attack / 0.05);
    _attack = 1.0;
    _hp -= 10 * d20;
    _specialized = false;
  }

  public String about() {
    return "The arcane wisdom of the practiced mage\n" +
	    "Eschews a sword, and reads a spell-book's page.";
  }
}

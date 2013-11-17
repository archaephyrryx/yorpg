// Peter Duchovni
// Period 9
// HW 24
// November 14, 2013
 
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

  public void special() {
    if (_gauge >= LEVELS[2]) { /* Third-level special ability */
      _attack = 2.0;
      _defence = 30; 
    } else if (_gauge >= LEVELS[1]) { /* Second-level special */
      _attack = 1.5;
      _defence = 20; 
    } else if (_gauge >= LEVELS[0]) { /* First-level special */
      _attack = 1.0;
      _defence = 10; 
    }
    _gauge = 0;
    _specialized = true;
  }

  public void normal() {
    _attack = 0.4;
    _defence = 40; 
    _specialized = false;
  }

  public String about() {
    return "Art thou a warrior, whose blood-lust knows no bound?";
  }
}

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
  }

  public Warrior( String name ) {
    this();
    _name = name;
  }
  public void special() {
    _attack = 1.0; /* That's a big 10/4, driver */
    _defence = 10; 
  }

  public void normal() {
    _attack = 0.4;
    _defence = 40; 
  }
}

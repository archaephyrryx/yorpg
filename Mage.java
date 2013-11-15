// Peter Duchovni
// Period 9
// HW 24
// November 14, 2013
 
public class Mage extends Character {

  public Mage() {
    _name = "Canned Elf"; /* Uruk-Hai cuisine is...*unique* */
    _hp = 300; /* High hp, low defence */
    _strength = 50; /* Not very strong */
    _defence = 20; /* Defenceless */
    _attack = 2; /* Magic Missile */
  }

  public Mage( String name ) {
    this();
    _name = name;
  }

  public void special() {
    _attack = 0; /* Make manifest, not war */
    _hp = 400; /* HEAL SELF */
  }

  public void normal() {
    _attack = 2; /* Gave peace a chance */
    _hp = (_hp > 300) ? 150 : _hp; /* Normalizes health */
  }

}

// Peter Duchovni
// Period 9
// HW 24
// November 14, 2013

public class Monster extends Character {
  public Monster() {
    _hp = 150;
    _name = "E. Magnet";
    _defence = 20;
    _attack = 1;
    _strength = (int) (Math.random() * 45) + 20;
    final boolean _specialized = false;
    final int _gauge = 0;
  }

  public void special() { }
  public void normal() { }
  public String about() { return ""; }
}

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
  }

  public void special() {
    _defence = 10;
    _attack = 2;
  }
  public void normal() {
    _defence = 20;
    _attack = 1;
  }
}

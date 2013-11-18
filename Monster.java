/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/

public class Monster extends Character {
  public Monster() {
    _hp = 150;
    _name = "E. Magnet";
    _defence = 20;
    _attack = 1;
    _strength = (int) (Math.random() * 45) + 20;
    final int _gauge = 0;
  }

  public void special(Character enemy) { }
  public void normal() { }
  public String about() { return ""; }
}

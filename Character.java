// Peter Duchovni
// Period 9
// Homework 24
// November 14, 2013

abstract class Character {
  protected int _hp;
  protected int _strength;
  protected int _defence;
  protected double _attack;
  protected String _name;

  public boolean isAlive() {
    return (_hp > 0);
  }

  public void lowerHp( int damage ) {
    _hp -= damage;
  }

  public int getDefence() { return _defence; }
  public String getName() { return _name; }

  public int attack( Character istic ) {
    int damage;
    damage = ((int) (_strength * _attack)) - istic.getDefence();
    damage = (damage < 0) ? 0 : damage;
    istic.lowerHp(damage);
    return damage;
  }

  abstract void normal();
  abstract void special();
  public static String about() {
    String warrior = "Art thou a warrior, whose blood-lust knows no bound?\n";
    String rogue = "Or clever rogue, who creeps without a sound?\n";
    String mage = "The arcane wisdom of the practiced mage\n" +
	    "Eschews a sword, and reads a spell-book's page.";
    
    return (warrior + rogue + mage);
  }
}

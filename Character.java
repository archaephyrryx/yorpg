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
  protected int _gauge;
  protected boolean _specialized;
  protected final int LEVELS[3] = {1, 3, 5};

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
    String rogue = "Or clever rogue, who creeps without a sound?\n";
    
    return (warrior + rogue + mage);
  }
}

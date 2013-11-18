abstract class Character {
  protected int _hp;
  protected int _strength;
  protected int _defence;
  protected double _attack;
  protected String _name;
  protected int _gauge;
  protected boolean _specialized = false;
  protected final int[] LEVELS = {1, 3, 5};

  public boolean isAlive() {
    return (_hp > 0);
  }

  public void lowerHp( int damage ) {
    _hp -= damage;
  }

  public void increment() {
    ++_gauge;
  }

  public int getLevel() {
    return (_gauge >= LEVELS[2]) ? 3 :
           (_gauge >= LEVELS[1]) ? 2 :
	   (_gauge >= LEVELS[0]) ? 1 : 0;
  }

  public int getHp() { return _hp; }
  public int getDefence() { return _defence; }
  public int getStrength() { return _strength; }
  public double getAttack() { return _attack; }
  public String getName() { return _name; }
  public boolean isSpecialized() { return _specialized; }

  public int attack( Character istic ) {
    int damage;
    damage = ((int) (_strength * _attack)) - istic.getDefence();
    damage = (damage < 0) ? 0 : damage;
    istic.lowerHp(damage);
    return damage;
  }

  abstract void normal();
  abstract void special(Character enemy);
  public abstract String about();
}

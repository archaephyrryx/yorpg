/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/

public class Nerd extends Character {
  public Nerd() {
    _name = "Linus Snowden";
    _hp = 100;
    _strength = (int) (10 + 25 * Math.random());
    _defence = 180;
    _attack = 0.5;
    _gauge = 0;
  }

  public Nerd( String name ) {
    this();
    _name = name;
  }

  public void special(Character enemy) {
      if (getLevel() > 0) {
            int multiplier = 0;
    if (_gauge >= LEVELS[2]) { /* Third-level special ability */        multiplier = 10;
    } else if (_gauge >= LEVELS[1]) { /* Second-level special */    
    } else if (_gauge >= LEVELS[0]) { /* First-level special */     multiplier = -10;
    }
        int modifier = (int) (multiplier * Math.random() + 1);
        _strength = enemy.getStrength() + modifier;
        _defence = enemy.getDefence() + modifier;
        _attack = enemy.getAttack() + ((int) modifier * 0.05);
    _gauge = 0;
    _specialized = true;
      }
  }

  public void normal() {
    _specialized = false;
    _strength = (int) (10 + 25 * Math.random());
    _defence = 180;
    _attack = 0.5;
  }

  public String about() {
    return "Nerd";
  }
}

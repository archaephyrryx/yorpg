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
      int multiplier;
      switch (getLevel()) {
        case 3:
          multiplier = 10;
          break;
	case 2:
	  multiplier = 0;
        case 1:
	  multiplier = -10;
	  break;
      }
		
      /* Ranges for modifier
		   Level 1: -9 to 1
		   Level 2:    1
		   Level 3:  1 to 11
      */
      int modifier = (int) (multiplier * Math.random() + 1);

      _strength = enemy.getStrength() + modifier;
      _defence = enemy.getDefence() + modifier;
      _attack = enemy.getAttack() + ((int) modifier * 0.05);
      
      System.out.println("Thou hast assumed the guise of thine enemy!");
    }
  }

  public void normal() {
    _gauge = 0;
    _strength = (int) (10 + 25 * Math.random());
    _defence = 180;
    _attack = 0.5;
  }

  public String about() {
    return  "The nerd pursues an intellectual life\n" +
            "Away from battles and all sorts of strife\n" +
            "And finds no gain in learning skills of blade\n" +
            "And would much rather study in the shade.\n" +
            "Yet, when in battle, foes should best take care:\n" +
            "The nerd hath strategies one must beware.\n" +
            "For though his frame is slight, a nerd is cunning,\n" +
            "With inner strength that sends a dragon running;\n" +
            "For he can LARP as well as any LARPER.\n" +
            "And so, of nerds, not knights, will sing the harper.";
  }
}

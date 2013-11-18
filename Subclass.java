public class Subclass extends Character {
  public Subclass() {
    /* Set Attributes Here */
    _gauge = 0;
  }

  public Subclass( String name ) {
    this();
    _name = name;
  }

  public void special() {
    if (getLevel() != 0) {
      switch (getLevel()) {
	case 3: /* Third-level special ability */
	  break;
	case 2: /* Second-level special */
	  break;
	case 1: /* First-level special */
	  break;
      }
      _specialized = true;
    }
  }

  public void normal() {
    if (_specialized) {
      /* Normalization */
      _gauge = 0;
      _specialized = false;
    }
  }

  public String about() {
    return "Subclass";
  }
}

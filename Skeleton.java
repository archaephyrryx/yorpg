public class [SUBCLASS] extends Character {
  public [SUBCLASS]() {
    /* Set Attributes Here */
    _gauge = 0;
  }

  public [SUBCLASS]( String name ) {
    this();
    _name = name;
  }

  public void special() {
    if (_gauge >= LEVELS[2]) { /* Third-level special ability */
    } else if (_gauge >= LEVELS[1]) { /* Second-level special */
    } else if (_gauge >= LEVELS[0]) { /* First-level special */
    }
    _gauge = 0;
    _specialized = true;
  }

  public void normal() {
    /* Normalization */
    _specialized = false;
  }

  public String about() {
    return "[SUBCLASS]";
  }
}

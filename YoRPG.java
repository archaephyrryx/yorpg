/*
    RPG Game
    by Peter Duchovni, Nicholas Romanoff, and Philipp Steinmann
*/

import java.io.*;
import java.util.*;

public class YoRPG {

    public final static int MAX_ENCOUNTERS = 5;

    private Monster enemy;
    private Character hero;

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;

    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }

    public void newGame() {
	String s;
	int knowMoreChoice = 0;
	String name = "";
	String type = "";
	s = "Welcome to Thy Elden Role-Playing Gambit!\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Alas, mine ego cannot bear to lose / So this the least demanding I will choose\n";
	s += "\t2: I would not deign to claim I am the best / But neither will I choose the simple quest \n";
	s += "\t3: No man of woman born can take my life / I feel no fear for any but my wife.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "O valiant, gallant hero, wide in fame\nThe bards who write your song will use what name? ";
	System.out.println();
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	System.out.println();
        s =  "O noble hero, of whom wouldst though most yearn,\n";
	s += "The features, traits and powers of to learn?\n";
	s += "If you seek to know of more than one,\n";
	s += "Simply add together, and be done.\n";
	s += "\t0: There is not a need to teach.\n";
	s += "\t1: The sorcerer, whose powers leech.\n";
	s += "\t2: The mighty warrior, great of might.\n";
	s += "\t4: The rogue, whose steps are feather-light.\n";
	s += "\t8: The subtle mage, with fearsome wrath.\n";
	s += "\t16: The quiet nerd, adept in math\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    knowMoreChoice = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

        if (((knowMoreChoice / 1) % 2) == 1) {
          System.out.println( (new Sorcerer()).about() );
	  System.out.println();
	}
        if (((knowMoreChoice / 2) % 2) == 1) {
	  System.out.println( (new Warrior()).about() );
	  System.out.println();
        }
        if (((knowMoreChoice / 4) % 2) == 1) {
          System.out.println( (new Rogue()).about() );
	  System.out.println();
	}
        if (((knowMoreChoice / 8) % 2) == 1) {
          System.out.println( (new Mage()).about() );
	  System.out.println();
        }
        if (((knowMoreChoice / 16) % 2) == 1) {
	  System.out.println( (new Nerd()).about() );
	  System.out.println();
	}

        System.out.println("Choose a sub-class for your hero,");
        System.out.println("Type one key or more, not zero:");

	try {
	    type = in.readLine();
	}
	catch ( IOException e ) { }

        if (type.substring(0,1).toLowerCase().equals("w"))
	  hero = new Warrior( name );
        if (type.substring(0,1).toLowerCase().equals("m"))
	  hero = new Mage( name );
        if (type.substring(0,1).toLowerCase().equals("n"))
	  hero = new Nerd( name );
        if (type.substring(0,1).toLowerCase().equals("r"))
	  hero = new Rogue( name );
        if (type.substring(0,1).toLowerCase().equals("s"))
	  hero = new Sorcerer( name );
    }

    public boolean playTurn() {
	int specialChoice = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) ) {
	    System.out.println();
	    System.out.println( "Thine eyes betray thee not, the field is bare\n" +
	                        "Thou willst tomorrow battle, if ye dare." );

	} else {
	    System.out.println();
	    System.out.println( "Forsooth, yon monster cometh closer every stride!" );
	    System.out.println( "The battle's victor Fate will soon decide!" );

	    enemy = new Monster();

	    System.out.println("Current HP: " + hero.getHp());
	    while( enemy.isAlive() && hero.isAlive() ) {

	        System.out.println();
		System.out.println("Special Ability Level " + hero.getLevel() + " Ready.\n");
	        System.out.println();
		try {
		    System.out.println( "Lo, willst thou tempt the Fates and bear the price?" );
		    System.out.println( "If nay, then say it once, if aye, then twice." );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    specialChoice  = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( specialChoice == 2 )
		    hero.special(enemy);


		d1 = hero.attack( enemy );
		d2 = enemy.attack( hero );

        if ( specialChoice == 2)
          hero.normal();
        else
		  hero.increment();

        System.out.println();
		System.out.println( hero.getName() + " dealt " + d1 + " points of damage."); 
		System.out.println( "Ye Olde Monster hit back for " + d2 + " points of damage."); 

		System.out.println("Current HP: " + hero.getHp());
	    }

	    if ( !enemy.isAlive() && !hero.isAlive() ) {
	        System.out.println();
		System.out.println( "The fight was long, and neither side prevailed \n" + 
				    "With blows each one his nemesis assailed; \n" +
				    "Yet in the end the Fates had seen it fit\n" +
				    "For man and beast, the mortal realm to quit." );
		return false;
	    }
	    else if ( !enemy.isAlive() ) {
	        System.out.println();
		System.out.println( "O praise, the vile beast is slain!" );
		System.out.println( "We beg of you to save us once again!" );
		return true;
	    }
	    else if ( !hero.isAlive() ) {
	        System.out.println();
		System.out.println( "O woe, the beast hath slain our knight," );
		System.out.println( "Who only once didst lose a fight." );
		return false;
	    }
	}

	return true;
    }
    public static void main( String[] args ) {

	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}


	System.out.println();
	System.out.println();
	System.out.println( "Thy quest has reached an end, thy game shall cease.\n"
	+ "To play again, insert one silver piece." );

    }
}

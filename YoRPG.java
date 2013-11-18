// Peter Duchovni
// Period 9
// HW 24
// November 14, 2013

import java.io.*;
import java.util.*;

public class YoRPG {

    public final static int MAX_ENCOUNTERS = 5;

    private Monster smaug;
    private Character pat;

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
	int know = 0;
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
	s += "\t0: I've no need of information.\n";
	s += "\t1: This one needs implementation.\n";
	s += "\t2: The mighty warrior, great of might.\n";
	s += "\t4: The rogue, whose steps are feather-light.\n";
	s += "\t8: The subtle mage, with fearsome wrath.\n";
	s += "\t16: The quiet nerd, adept in math\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    know = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

        if (((know/2) % 2) == 1)
	  System.out.println( (new Warrior()).about() );
	  System.out.println();
        if (((know/8) % 2) == 1)
          System.out.println( (new Mage()).about() );
	  System.out.println();

	/*
        if (((know/1) % 2) == 1)
          System.out.println( (new Subclass()).about() );
	  System.out.println();
        if (((know/4) % 2) == 1)
          System.out.println( (new Rogue()).about() );
	  System.out.println();
        if (((know/16) % 2) == 1)
	  System.out.println( (new Nerd()).about() );
	  System.out.println();
        */

        System.out.println("Choose a sub-class for your hero,");
        System.out.println("Type one key or more, not zero:");

	try {
	    type = in.readLine();
	}
	catch ( IOException e ) { }

        if (type.substring(0,1).toLowerCase().equals("w"))
	  pat = new Warrior( name );
        if (type.substring(0,1).toLowerCase().equals("m"))
	  pat = new Mage( name );
        if (type.substring(0,1).toLowerCase().equals("n"))
	  pat = new Nerd( name );
	/*
        if (type.substring(0,1).toLowerCase().equals("r"))
	  pat = new Rogue( name );
        if (type.substring(0,1).toLowerCase().equals("s"))
	  pat = new Subclass( name );
	*/
    }

    public boolean playTurn() {
	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) ) {
	    System.out.println();
	    System.out.println( "Thine eyes betray thee not, the field is bare\n" +
	                        "Thou willst tomorrow battle, if ye dare." );

	} else {
	    System.out.println();
	    System.out.println( "Forsooth, yon monster cometh closer every stride!" );
	    System.out.println( "The battle's victor Fate will soon decide!" );

	    smaug = new Monster();

	    System.out.println("Current HP: " + pat.getHp());
	    while( smaug.isAlive() && pat.isAlive() ) {
		pat.normal();

	        System.out.println();
		System.out.println("Special Ability Level " + pat.getLevel() + " Ready.\n");
	        System.out.println();
		try {
		    System.out.println( "Lo, willst thou tempt the Fates and bear the price?" );
		    System.out.println( "If nay, then say it once, if aye, then twice." );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
		    pat.special(smaug);


		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );

	        System.out.println();
		System.out.println( pat.getName() + " dealt " + d1 + " points of damage."); 
		System.out.println( "Ye Olde Monster hit back for " + d2 + " points of damage."); 

		System.out.println("Current HP: " + pat.getHp());
		pat.increment();
	    }

	    if ( !smaug.isAlive() && !pat.isAlive() ) {
	        System.out.println();
		System.out.println( "The fight was long, and neither side prevailed \n" + 
				    "With blows each one his nemesis assailed; \n" +
				    "Yet in the end the Fates had seen it fit\n" +
				    "For man and beast, the mortal realm to quit." );
		return false;
	    }
	    else if ( !smaug.isAlive() ) {
	        System.out.println();
		System.out.println( "O praise, the vile beast is slain!" );
		System.out.println( "We beg of you to save us once again!" );
		return true;
	    }
	    else if ( !pat.isAlive() ) {
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

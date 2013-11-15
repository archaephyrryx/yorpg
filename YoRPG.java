// Peter Duchovni
// Period 9
// HW 24
// November 14, 2013

import java.io.*;
import java.util.*;

public class YoRPG {

    public final static int MAX_ENCOUNTERS = 5;

    private Warrior pat;
    private Monster smaug;

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
	String name = "";
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

	s = "O valiant, gallant hero, wide in fame / The bards who write your song will use what name? ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	pat = new Warrior( name );
    }

    public boolean playTurn() {

	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "Thine eyes betray thee not, the field is bare\n" +
	                        "Thou willst tomorrow battle, if ye dare." );

	else {
	    System.out.println( "Forsooth, yon monster cometh closer every stride!" );
	    System.out.println( "The battle's victor Fate will soon decide!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {
		try {
		    System.out.println( "Lo, willst thou tempt the Fates and bear the price?" );
		    System.out.println( "If nay, then say it once, if aye, then twice." );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
		    pat.special();
		else
		    pat.normal();

		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );

		System.out.println( pat.getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( "Ye Olde Monster hit back for " + d2 +
				    " points of damage.");
	    }
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "The fight was long, and neither side prevailed \n" + 
				    "With blows each one his nemesis assailed; \n" +
				    "Yet in the end the Fates had seen it fit\n " +
				    "For man and beast, the mortal realm to quit." );
		return false;
	    }
	    else if ( !smaug.isAlive() ) {
		System.out.println( "O praise, the vile beast is slain!" );
		System.out.println( "We beg of you to save us once again!" );
		return true;
	    }
	    else if ( !pat.isAlive() ) {
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

	/*=============================================
	System.out.println( "Thy game doth be over." );
	  =============================================*/

    }
}

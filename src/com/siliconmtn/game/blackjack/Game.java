package com.siliconmtn.game.blackjack;

// App libs
import com.siliconmtn.game.StandardDeck52;
import com.siliconmtn.game.person.Dealer;
import com.siliconmtn.game.person.Player;

/****************************************************************************
 * <b>Title</b>: Test.javaIncomingDataWebService.java
 * <p/>
 * <b>Project</b>: BlackJackProjectRAMDataFeed
 * <p/>
 * <b>Description: </b> <b>Copyright:</b> Copyright (c) 2014
 * <p/>
 * <b>Company:</b> Silicon Mountain Technologies
 * <p/>
 * 
 * @author Devon
 * @version 1.0
 * @since 3:34:23 PM
 *        <p/>
 *        <b>Changes: </b>
 ****************************************************************************/
public class Game {
	
	//set defaults for variables
	private double betTable = 5;
	private double startAmount = 10;
	private int numOfPlayers = 1;
	private GameMessage msg = null;
	
	// Main method
	public static void main(String[] args) {
		
		// Initialize the game
		Game game = new Game(5.00, 100.00, Rule21.minimumNumOfPlayers);
		
		// Setup the game dealer, rules and players
		game.setUpGame();
		
		// Play the game
		game.startGame();
		
		// End the game
		game.finishGame();
	}
	
	//Class Constructor
	public Game(double betTable, double startAmount, int numOfPlayer){
		//enter minimum bet, startAmount and #of Players
		this.betTable = betTable;
		this.startAmount = startAmount;
		this.numOfPlayers = numOfPlayer;
	}

	/**
	 * Sets up data needed for game
	 */
	public void setUpGame() {
		//get messages needed for game
		msg = new GameMessage();
		
		// get rules, get goal for game
		Rule21 rule = new Rule21();
		
		// Create Deck
		StandardDeck52 deck = new StandardDeck52();
		
		// Create the Dealer
		Dealer dealer = new Dealer("sue", "k", null, null);
		
			//Assign the rules and deck to dealer
		dealer.setRule(rule);
		dealer.setGameDeck(deck);
			//tell dealer #of Players and table minimum
		dealer.setNumOfPlayers(this.numOfPlayers);
		dealer.setTableMinimum(this.betTable);
		
		// Create the player(s)
		Player player1 = new Player("mike","rogers",null, null);
		
			// set start amount to player(s)
		player1.setTotalMoney(this.startAmount);		
		
	}

	/**
	 * Plays the game by checking players cards, determines results and keeps
	 * running until they lose all money or give up
	 */
	public void startGame() {
		System.out.println(msg.getMessage("WELCOME"));
		
		//set boolean to use in loop
		boolean isPlaying = true;
		
		//Begin loop for game here while(they want to keep playing)
		while(isPlaying) {
		
		// Ask how much they want to bet this round

		// dealer deals cards (Dealer)
			//should have loop that deals cards based on # of players

		// display cards for dealer and players (Dealer/Player)
			//should have loop here too
		
		// prompt player if they want another card (Dealer)
			//loop here too
		
			// if so give another card

			// if no have dealer reveal other card

			// if dealer has 16 or less have to take another card

		// get dealer and players hand(Dealer, Player)

		// determine if they busted, if they do they lose that round (Rule21)

			// compare each players hand to decide who wins (Rule21)

		// display message if dealer wins, player wins, or a draw

		// prompt player if they want to play again(Dealer)
		}

	}
	
	/**
	 * Runs when game is over and gives message and rating to player
	 */
	private void finishGame(){
		//Display general game over message
		
		//Give rating for how well they did based on amount of money they have
	}
}

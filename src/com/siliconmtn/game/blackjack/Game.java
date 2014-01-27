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

	// create and set defaults for variables
	private double betTable = 5;
	private double startAmount = 10;
	private GameMessage msg = null;
	private Dealer dealer = null;

	// Main method
	public static void main(String[] args) {

		// Initialize the game
		Game game = new Game(5.00, 100.00);

		// Setup the game dealer, rules and players
		game.setUpGame();

		// Play the game
		game.startGame();
		
		//End the game
		game.finishGame();
	}

	// Class Constructor
	public Game(double betTable, double startAmount) {
		// enter minimum bet, startAmount and #of Players
		this.betTable = betTable;
		this.startAmount = startAmount;
	}

	/**
	 * Sets up data needed for game
	 */
	public void setUpGame() {
		// get messages needed for game
		msg = new GameMessage();

		// get rules, get goal for game
		Rule21 rule = new Rule21();

		// Create Deck
		StandardDeck52 deck = new StandardDeck52();

		// Create the Dealer
		Dealer gameDealer = new Dealer("Mary", "k", null, null);
		this.dealer = gameDealer;

		// Assign the rules, deck and minimum amount of players to dealer
		gameDealer.setRule(rule);
		gameDealer.setGameDeck(deck);
		gameDealer.setTableMinimum(this.betTable);
		
		//should shuffle deck
		gameDealer.getGameDeck().shuffle();
		
		// Create the player(s)
//		Player player1 = addPlayer("Mike", "rogers", this.startAmount);
//		Player player2 = addPlayer("Sue", "rogers", this.startAmount);
		Player player3 = addPlayer("James", "Camire", this.startAmount);
		Player player4 = addPlayer("Tim", "Johnson", this.startAmount);

		// add players to a list of players to let dealer know
//		addToList(player1);
//		addToList(player2);
		addToList(player3);
		addToList(player4);

	}
	
	/**
	 * Creates a player and assigns them a start amount
	 * @param first
	 * @param last
	 * @param startAmount
	 * @return a single player
	 */
	public Player addPlayer(String first, String last, double startAmount) {
		Player player = new Player(first, last, null, null);
		player.setTotalMoney(startAmount);

		return player;
	}
	
	/**
	 * adds players to a list for dealer to keep track of
	 * 
	 * @param gamePlayer
	 */
	public void addToList(Player gamePlayer) {
		dealer.getGamePlayers().add(gamePlayer);
	}

	/**
	 * Plays the game by checking players cards, determines results and keeps
	 * running until they lose all money or give up
	 */
	public void startGame() {
		System.out.println(msg.getMessage("WELCOME"));
		System.out.println(msg.getMessage("TABLE") + this.betTable);
		System.out.println(msg.getMessage("START_AMOUNT") + this.startAmount);

		// set boolean to use in loop
		boolean isPlaying = true;

		// Begin loop for game here while(they want to keep playing)
		while (isPlaying) {

			// branch out to method in dealer and let dealer class
			// handle the rest of the game
			
			// after runGame is done will return true or false
			this.dealer.runGame();
			
			//ask if they want to play again
			System.out.println(msg.getMessage("PLAY_AGAIN"));
			if(this.dealer.userInput() == 2){
				isPlaying  = false;
			}

		}

	}

	/**
	 * Runs when game is over and gives message and rating to player
	 */
	private void finishGame() {
		// Display general game over message
		System.out.println(msg.getMessage("GAME_OVER"));
	}
}
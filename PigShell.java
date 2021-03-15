/*
 *Name: Tejkuamr panchal  
 *Date: 09-19-2020
 */

/*
 * This project is about the game, which will play between computer
 * and player. In this game first computer takes turn and then
 * it will rolled three times random number then sum that three 
 * numbers which will become computer's score. After that user 
 * will get the chance to play a game. In user's turn if user 
 * entered any key then loop is continues, if he types 'end'
 * the loop will break, also if the user get the 1 in random
 * number then user's score become '0' and computer turn began.
 * whoever reach at the 30 or more than points then that 
 * player will win the game.
 */

import java.util.*;

public class PigShell {

	// This method displays the instructions to play the game.//
	public static void description() {
		System.out.println("Welcome to the game of Pig!");
		System.out.println("Both players start off with zero points.");
		System.out.println("Computer roll the dice three times in a row, the sum of the dice will be payers point");
		System.out.println("Player will be prompted to enter a key or enter \"end\"");
		System.out.println("Every time the player enter a key a dice will be rolled");
		System.out.println("If the dice is a 1, the player will loose all the points and player's turn is over");
		System.out.println("As long as the player dice is not the one, player will keep playing");
		System.out.println("Then computer turn begins");
		System.out.println("Player and the computer take turn playing");
		System.out.println("The first player to reach 30 points or more wins.");
		System.out.println();
	}

	/*
	 * This main method will call the other method 
	 * Which will help the program to run. 
	 */
	public static void main(String[] args) {
		
		// print description
		description();
		
		// call the play method
		play();
	}
	
	/* 
	 * This play method will create a random number for 
	 * computer and player to play the game. 
	 */
	public static void play() {
		
		// Generate Random number for computer and user 
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		boolean flag = true; // a flag to end the game
		int compScore = 0; // computer total score
		int playerScore = 0;// player total score
		int compToss = 0; // holds the sum of the three dice rolled
		int playerToss = 0;// hold the value of the rolled dice for the player
		int pRound = 0; // number of the round player won
		int cRound = 0; // number of the round computer won
		
		// While loop, if player wants play game again
		while (flag) {
			// reset all the variables to zero for a new round of the game
			compScore = 0;
			playerScore = 0;
			compToss = 0;
			playerToss = 0;

			// loop until either the computer wins or the player wins
			X: while (!(compScore >= 30 || playerScore >= 30)) {

				// generate three random numbers 1-6, three times
				System.out.println("Computers turn");
				int num1 = rand.nextInt(6) + 1;
				int num2 = rand.nextInt(6) + 1;
				int num3 = rand.nextInt(6) + 1; // 0-5 + 1 --> 1-6
				
				//CompToss will return the three random numbers 
				compToss = num1 + num2 + num3;

				System.out.print("Computer rolled a " + num1 + ", " + num2 + ", and " + num3);
				// add the random numbers to the computer total points
				compScore += compToss;
				System.out.println();
				System.out.println("Computer score is now:" + compScore);
				
				// If computer Score is grater than 30, loop will break
				if (compScore >= 30) {
					break X;
				}

				System.out.println();
				System.out.println("Players turn");
				System.out.println("Player Score is now :" + playerScore);

				// loop until the player get a one
				Y: while (playerToss != 1) {

					// prompt the player to enter a key or enter end
					System.out.println();
					System.out.println("Type any key to roll or 'end' to end turn");
					String ans = scan.nextLine();

					// if the player enters "end" break to of the loop
					if (ans.equalsIgnoreCase("end")) {
						System.out.println("Players turn is over.");
						System.out.println();
						// Break Second while loop named X
						break X;
					}
					
					playerToss = rand.nextInt(6) + 1; // else roll the dice, by generating a random number 1-6
					System.out.println("Player rolled a " + playerToss);

					if (playerToss != 1) {
						// add the playerToss to the playerScore and display the player score
						playerScore += playerToss;
						System.out.println("Player score is now: " + playerScore);

					}
					// if the playerToss is one, display a message that you got a 1, and your turn is over
					else {
						System.out.println("Player got a 1. Score reset to 0");
						System.out.println("Players turn is over.");
						System.out.println();
						playerToss = 0; // reset the playerToss to zero
						playerScore = 0; // reset the playerScore to Zero
						
						// Break Second while loop named Y
						break Y;
					}
					
					// check to see if the playerScore is greater than 30, if so break out of the loop
					if (playerScore >= 30) {
						break;
					}
				}
				
			}

			// check to see who was the winner
			if (compScore > playerScore) {
				System.out.println("Computer is the winner!");
				cRound++;
			} else {
				System.out.println("Player is the winner!");
				pRound++;
			}
			// ask if player wants to play another round
			System.out.println("Do you want to play another round?");
			String answer = scan.next();
			
			// If the answer is no then its will break the loop
			if (answer.equalsIgnoreCase("no")) {
				flag = false;
			}
		}
		// display the final score
		System.out.println("---- Final Score ----");
		System.out.println("Computer:  " + cRound + "   Player:  " + pRound);
	}
}

Overview:
This project implements a simple turn-based dice game called Pig, where a player competes against the computer. The primary goal is to be the first to accumulate 30 points or more.

Key Features:

Game Description: The game rules and instructions are displayed to the player.
Turn-Based Play: The computer rolls the dice three times per turn, and the sum of the rolls is added to its score. The player's turn follows, where they can continue to roll the dice or end their turn.
Dice Roll and Scoring: If a player rolls a 1, their turn ends and they lose all points accumulated in that turn. The game continues until a player reaches at least 30 points.
User Interaction: The player can choose to end their turn by typing "end". The game then switches to the computer's turn.
Code Structure:

description(): Displays the game rules.
main(): Initializes the game by calling the description method and then the play method.
play(): Manages the turns for both the computer and the player, handles dice rolls, and checks for the end of the game.

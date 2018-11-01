import javax.swing.JOptionPane;

public class HM1_RoeeAviran {
/*Name: Roee Aviran
ID: 316492644 */
	
	public static void main(String[] args) {
		String player1 = JOptionPane.showInputDialog("Enter Name Of Player 1");
		String player2 = JOptionPane.showInputDialog("Enter Name Of Player 2");
		String minNumString, maxNumString;
		int minNumber, maxNumber;
		
		//A do while loop which prevents the players from inserting a wrong number range.
		do {
			minNumString = JOptionPane.showInputDialog("Enter Range[MIN]");
			maxNumString = JOptionPane.showInputDialog("Enter Range[Max]");
			maxNumber = Integer.parseInt(maxNumString);
			minNumber = Integer.parseInt(minNumString);
			if (minNumber > maxNumber) {
				JOptionPane.showMessageDialog(null, "[MIN] Range Is Greater Than [MAX] Range Please"
				+ " Insert A Range Whos [MAX] Is Greater Than Its [MIN]", "Wrong Range!", JOptionPane.ERROR_MESSAGE);
			} 
		} while (maxNumber < minNumber);
		
		int randomNumber = (int)(Math.random() * (maxNumber + 1 - minNumber) ) + minNumber;
		int guess, tries1 = 0, tries2 = 0;
		String guessString;
		
		/*If player1's first guess is not on point, java will enter a while loop until it is found.
		each loop consists of 1 attempt from player1 OR player 2.*/
		JOptionPane.showMessageDialog(null, "A Random Number In Range Of " + minNumber + " And "
		+ maxNumber + " Has Been Generated Successfully!");
		guessString = JOptionPane.showInputDialog(null, "Player " + player1 + " Insert Your Guess [Between "
		+ minNumber + " And " + maxNumber + "]:", player1 + "'s Turn!", JOptionPane.QUESTION_MESSAGE);
		guess = Integer.parseInt(guessString);
		tries1++;
		
		//From here on Java will give a clue to the player each turn (greater or less than the number).
		while (randomNumber != guess) {
			if (tries1 > tries2) {
				tries2++;
				if (randomNumber > guess) {
					guessString = JOptionPane.showInputDialog(null, "Player " + player2 + " Insert Your Guess [Between "
				+ minNumber + " And " + maxNumber + "]: \n The Number Is Greater Than " + guess, player1 + "'s Turn!"
				, JOptionPane.QUESTION_MESSAGE);
				}
				else {
					guessString = JOptionPane.showInputDialog(null, "Player " + player2 + " Insert Your Guess [Between "
					+ minNumber + " And " + maxNumber + "]: \n The Number Is Less Than " + guess, player1 + "'s Turn!"
					, JOptionPane.QUESTION_MESSAGE);
				}
				guess = Integer.parseInt(guessString);
			}
			else if (tries1 == tries2) {
				tries1++;
				if (randomNumber > guess) {
					guessString = JOptionPane.showInputDialog(null, "Player " + player1 + " Insert Your Guess [Between "
				    + minNumber + " And " + maxNumber + "]: \n The Number Is Greater Than " + guess, player1 + "'s Turn!"
				    , JOptionPane.QUESTION_MESSAGE);
				}
				else {
					guessString = JOptionPane.showInputDialog(null, "Player " + player1 + " Insert Your Guess [Between "
					+ minNumber + " And " + maxNumber + "]: \n The Number Is Less Than " + guess, player1 + "'s Turn!"
					, JOptionPane.QUESTION_MESSAGE);
				}
				guess = Integer.parseInt(guessString);
			}
		}
		
		/*Player1 is the one who went first, therefore as the number is found, if player2 has the
		 *  same number of tries as player1 - it means that player2 has won the game.*/
		if (tries1 > tries2) {
			JOptionPane.showMessageDialog(null, player1 + " WINS! The Game! \n Number Of Tries: " + tries1);
		}
		else {
			JOptionPane.showMessageDialog(null, player2 + " WINS! The Game! \n Number Of Tries: " + tries2);
		}
}}

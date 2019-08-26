/**
This class contains the main method and it's responsible for reading user's input and calling methods from the Game class.
@author Edgar Cobos
*/
public class Main {
	public static void main(String[] args) {
		Game game = new Game();

		while(!game.hasEnded() && !game.q()) {
			System.out.println("You are guessing:" + game.displayHiddenMovieTitle());
			System.out.println("You have guessed (" + game.getPointsLost() + ") wrong letters: " + game.getLetters());
			game.guessLetter();
		}

		if(game.isWon()) {
			System.out.println("You win!");
			System.out.println("You have guessed " + game.displayMovieTitle() + " correctly.");
		}
		else if(game.isLost()){
			System.out.println("You have guessed (" + game.getPointsLost() + ") wrong letters: " + game.getLetters());
			System.out.println("You lost!");
			System.out.println("The movie title was " + game.displayMovieTitle());
		}
	}
}
import java.util.Scanner;
/**
This class represents a movie guessing game and it's responsible for handling a single guess and displaying the hidden movie title.
@author Edgar Cobos
*/
public class Game {
	private String movieTitle;
	private String correctLetters;
	private int pointsLost;
	private String incorrectLetters;
	private boolean q;

	public Game() {
		MovieList movies = new MovieList();
		movieTitle = movies.getRandomMovie();
		correctLetters = "";
		pointsLost = 0;
		incorrectLetters = "";
		q = false;
	}

	public String displayHiddenMovieTitle() {
		if(correctLetters.equals("")) {
			return movieTitle.replaceAll("[a-zA-Z]", "_");
		}
		else {
			return movieTitle.replaceAll("[a-zA-Z&&[^" + correctLetters + "]]", "_");
		}
	}

	public String displayMovieTitle() {
		return movieTitle;
	}

	public int getPointsLost() {
		return pointsLost;
	}

	public String getLetters() {
		return incorrectLetters;
	}

	public boolean isWon() {
		if(!displayHiddenMovieTitle().contains("_")) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isLost() {
		if(pointsLost == 10) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean hasEnded() {
		if(isWon() || isLost()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean q() {
		return q;
	}

	private String inputLetter() {
		System.out.print("Guess a letter:");
		Scanner scanner = new Scanner(System.in);
		String letter = scanner.nextLine().toLowerCase();

		if(!letter.matches("[a-z]") && !letter.equals("quit")){
			System.out.println("Did not guessed a letter.");
			return inputLetter();
		}
		else if(correctLetters.contains(letter) || incorrectLetters.contains(letter)) {
			System.out.println("Letter already guessed.");
			return inputLetter();
		}
		else {
			return letter;
		}
	}

	public void guessLetter() {
		String guessedLetter = inputLetter();
		if(guessedLetter.equals("quit")) {
			q = true;
		}
		else if(movieTitle.contains(guessedLetter)) {
			correctLetters += guessedLetter;
		}
		else {
			pointsLost++;
			incorrectLetters += " " + guessedLetter;
		}
	}
}
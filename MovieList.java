import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
This class represents a movie list and it's responsible for randomly picking a title.
@author Edgar Cobos
*/
public class MovieList {
	private ArrayList <String> movies = new ArrayList();
	
	public MovieList() {
		File file = new File("movies.txt");
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				movies.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist!");
		}
	}

	public String getRandomMovie() {
		int i = (int) (Math.random() * movies.size());
		return movies.get(i);
	}
}
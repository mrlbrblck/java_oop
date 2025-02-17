import  java.util.*;
public class MovieCollection {
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public void addMovie(String title, String director, int releaseYear, String genre) {
        Movie movie = new Movie(title, director, releaseYear, genre);
        movies.add(movie);
    }

    public void removeMovie(String title) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().equals(title)) {
                movies.remove(i);
                return;
            }
        }
        System.out.println("Movie not found");
    }

    public void displayAllMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void displayMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                System.out.println(movie);
                return;
            }
        }
        System.out.println("Movie not found");
    }
    
}

import  java.util.*;
public class MovieCollection {
    private final ArrayList<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
        System.out.println("Added: " + movie);
    }

    public void removeMovie(String title) {
        movies.removeIf(movie -> movie.getTitle().equalsIgnoreCase(title));
        System.out.println("Removed movie titled: " + title);
    }

    public List<Movie> findMovies(String query) {
        List<Movie> results = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(query) || movie.getDirector().getName().equalsIgnoreCase(query)) {
                results.add(movie);
            }
        }
        return results;
    }

    public void listMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies in the collection.");
        } else {
            System.out.println("Movie Collection:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }
}

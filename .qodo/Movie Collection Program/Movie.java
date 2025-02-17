public class Movie {
    private final String title;
    private final String genre;
    private final int year;
    private final int duration;
    private final Director director;
    private final double rating;

    public Movie(String title, String genre, int year, int duration, Director director, double rating) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return title + " (" + year + ") - Genre: " + genre + " - Duration: " + duration + " mins - "
                + "Directed by " + director.getName() + " - Rating: " + rating;
    }
}
public class Movie {
    String title;
    String director;
    int releaseYear;
    String genre;

    public Movie(String title, String director, int releaseYear, String genre) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }
    @Override
    public String toString() {
        return "Title: " + title + "\nDirector: " + director + "\nRelease Year: " + releaseYear + "\nGenre: " + genre;
    }    
    public String getTitle() {
        return title;
    }
}

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();
        String command;

        System.out.println("Welcome to the Movie Collection Manager!");

        while (true) {
            System.out.print("\nCommand (add, remove, find, list, exit): ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Release Year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Duration (in mins): ");
                    int duration = Integer.parseInt(scanner.nextLine());
                    System.out.print("Director's Name: ");
                    String directorName = scanner.nextLine();
                    System.out.print("Rating: ");
                    double rating = Double.parseDouble(scanner.nextLine());
                    
                    collection.addMovie(new Movie(title, genre, year, duration, new Director(directorName), rating));
                    break;

                case "remove":
                    System.out.print("Enter movie title to remove: ");
                    String removeTitle = scanner.nextLine();
                    collection.removeMovie(removeTitle);
                    break;

                case "find":
                    System.out.print("Enter title or director to find: ");
                    String searchQuery = scanner.nextLine();
                    List<Movie> foundMovies = collection.findMovies(searchQuery);
                    if (!foundMovies.isEmpty()) {
                        for (Movie movie : foundMovies) {
                            System.out.println("Found: " + movie);
                        }
                    } else {
                        System.out.println("No movies found matching the query.");
                    }
                    break;

                case "list":
                    collection.listMovies();
                    break;

                case "exit":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }
}

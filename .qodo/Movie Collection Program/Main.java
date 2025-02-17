import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieCollection movieCollection = new MovieCollection();
        String command;

        System.out.println("Welcome to the Movie Collection Program!");
        System.out.println("What do you want to do today?");
        
        while (true) {
            System.out.println("(Add, Remove, Find, List, Exit)");
            command = sc.nextLine().trim().toLowerCase();
            switch (command) {

                case "add" -> {
                    System.out.println("Title:");
                    String name = sc.nextLine();
                    System.out.println("Director:");
                    String director = sc.nextLine();
                    System.out.println("Release Year:");
                    int releaseYear = Integer.parseInt(sc.nextLine());
                    System.out.println("Genre: ");
                    String genre = sc.nextLine();

                    movieCollection.addMovie(name, director, releaseYear, genre);
                    System.out.println("Movie added successfully!");
                }

                case "remove" -> {
                    System.out.println("Enter the name of the movie to be removed");
                    String name = sc.nextLine();
                    movieCollection.removeMovie(name);
                }
                case "list" -> movieCollection.displayAllMovies();
                case "find" -> {
                    System.out.println("Enter the name of the movie to be displayed");
                    String name = sc.nextLine();
                    movieCollection.displayMovie(name);
                }
                case "exit" -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
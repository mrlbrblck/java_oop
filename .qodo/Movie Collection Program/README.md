# Movie Collection Program

## Overview
This **Movie Management System** is a simple Java-based console application that allows users to manage a collection of movies. Users can add, remove, find, and list movies through an interactive command-line interface. The program follows **Object-Oriented Programming (OOP)** principles and supports searching for movies by **title** or **director**.

## Key Features
- **Add a Movie**: Users can input details such as title, genre, release year, duration, director's name, and rating.
- **Remove a Movie**: Deletes a movie by its title.
- **Find a Movie**: Users can search by title or director's name.
- **List All Movies**: Displays all movies stored in the collection.
- **Exit Program**: Ends the session safely.

## Technologies Used
- **Java (JDK 8 or higher)**
- **Object-Oriented Programming (OOP)**
- **Scanner for User Input**
- **Loops (while loop for program execution)**
- **ArrayList for dynamic movie storage**

## Classes and Structure
1. **Person** (Base class) - Stores a person's name.
2. **Director** (Extends Person) - Represents a movie director.
3. **Movie** - Stores details about a movie, including its title, genre, release year, duration, director, and rating.
4. **MovieCollection** - Manages movie storage and provides methods to add, remove, find, and list movies.
5. **Main** - Contains the program's entry point, handles user input, and runs the main loop.

## Algorithms Used
### 1. **Movie Search Algorithm**
- Iterates through the movie list to find movies that match the search query (either by title or director).
- Uses a **case-insensitive** comparison for better user experience.

### 2. **Dynamic List Management**
- Uses an `ArrayList<Movie>` to store and manage movies.
- Allows efficient adding, removing, and searching of movies.

### 3. **While Loop for User Interaction**
- A `while (true)` loop keeps the program running until the user inputs "exit."
- The loop processes user commands and calls the respective methods.

## How to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/mrlbrblk/Movie-Management-System.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Movie-Management-System
   ```
3. Compile the Java files:
   ```sh
   javac Main.java
   ```
4. Run the program:
   ```sh
   java Main
   ```

## Future Improvements
- Implement file storage to save movies between sessions.
- Add a graphical user interface (GUI) for better usability.
- Improve search functionality with partial matching and filtering options.

---
This project demonstrates fundamental **OOP principles** and **basic data handling** in Java. Contributions and improvements are welcome!


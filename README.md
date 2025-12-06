# Advent of Java

This repository contains solutions for the Advent of Code challenges, implemented in Java.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

*   Java 24
*   Maven

## Project Structure

```
.
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── dev
    │   │       └── ghidora
    │   │           └── advent_of_java
    │   │               ├── Main.java
    │   │               ├── common
    │   │               │   ├── Puzzle.java
    │   │               │   ├── PuzzleFactory.java
    │   │               │   └── PuzzleName.java
    │   │               └── day1 // Example
    │   │                   └── Day1.java // Example
    │   └── resources
    │       └── day1_input.txt // Example
    └── test
        └── java
```

*   **`src/main/java`**: Contains the main source code.
    *   **`common`**: Holds the common logic for all puzzles, like the `Puzzle` interface and the `PuzzleFactory`.
    *   **`dayX`**: Each day's solution is in its own package.
*   **`src/main/resources`**: Contains the input files for each puzzle.
*   **`pom.xml`**: Defines the project's dependencies and build settings.

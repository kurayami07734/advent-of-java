package dev.ghidora.advent_of_java;

import dev.ghidora.advent_of_java.common.Puzzle;
import dev.ghidora.advent_of_java.common.PuzzleFactory;
import dev.ghidora.advent_of_java.common.PuzzleName;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java AoCCLI <PUZZLE_NAME_ENUM> <INPUT_PATH>");
            System.exit(1);
        }
        try {
            PuzzleName puzzleName = PuzzleName.valueOf(args[0].toUpperCase());
            String filePath = args[1];

            System.out.println("Solving " + puzzleName + "...");

            Puzzle puzzle = PuzzleFactory.getPuzzle(puzzleName, filePath);

            puzzle.solve();

        } catch (IllegalArgumentException e) {
            System.err.println("Invalid Problem Name or File Path.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
        }
    }
}
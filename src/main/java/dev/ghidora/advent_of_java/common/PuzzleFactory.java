package dev.ghidora.advent_of_java.common;

public class PuzzleFactory {
    public static Puzzle getPuzzle(PuzzleName puzzleName, String filePath) {
        switch (puzzleName) {
            default:
                throw new UnsupportedOperationException("Puzzle not solved yet!");
        }
    }
}

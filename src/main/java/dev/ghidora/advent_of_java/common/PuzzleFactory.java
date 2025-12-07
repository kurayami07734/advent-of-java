package dev.ghidora.advent_of_java.common;

import dev.ghidora.advent_of_java.puzzles.DayOne2025;

public class PuzzleFactory {
    public static Puzzle getPuzzle(PuzzleName puzzleName, String filePath) {
        switch (puzzleName) {
            case DAY_1_2025:
                return new DayOne2025(filePath);
            default:
                throw new UnsupportedOperationException("Puzzle not solved yet!");
        }
    }
}

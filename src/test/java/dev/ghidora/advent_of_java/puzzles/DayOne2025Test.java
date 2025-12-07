package dev.ghidora.advent_of_java.puzzles;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOne2025Test {

    // The example input provided in the puzzle description
    private final List<String> EXAMPLE_INPUT = List.of(
            "L68", "L30", "R48", "L5", "R60",
            "L55", "L1", "L99", "R14", "L82"
    );

    @Test
    void testPart1_ExampleCase() {
        DayOne2025 puzzle = new DayOne2025(EXAMPLE_INPUT);
        // The puzzle description says the answer for Part 1 is 3
        assertEquals(3, puzzle.solvePart1());
    }

    @Test
    void testPart2_ExampleCase() {
        DayOne2025 puzzle = new DayOne2025(EXAMPLE_INPUT);
        // The puzzle description says the answer for Part 2 is 6
        assertEquals(6, puzzle.solvePart2());
    }

    @Test
    void testPart2_EdgeCase_LeftFromZero() {
        // Dial starts at 50.
        // L50 moves it to 0. (Passes 0? No, lands on it. Remainder logic handles this).
        // L5 moves it from 0 to 95. (Should NOT count as passing 0).

        List<String> trickyInput = List.of("L50", "L5");

        DayOne2025 puzzle = new DayOne2025(trickyInput);

        // Breakdown:
        // Start: 50
        // L50: Moves to 0.
        //      Loop points: 0.
        //      Remainder check: 50 != 0 and 50-50 <= 0 -> YES. Points: 1.
        //      Current Pos: 0.

        // L5: Moves to 95.
        //     Loop points: 0.
        //     Remainder check: Pos is 0. 0 != 0 is False. -> NO points.
        //     Current Pos: 95.

        // Total Expected: 1
        assertEquals(1, puzzle.solvePart2());
    }

    @Test
    void testPart2_EdgeCase_FullLoops() {
        // R1000 should pass zero 10 times
        DayOne2025 puzzle = new DayOne2025(List.of("R1000"));
        assertEquals(10, puzzle.solvePart2());
    }
}
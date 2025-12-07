package dev.ghidora.advent_of_java.puzzles;

import dev.ghidora.advent_of_java.common.Puzzle;

import java.util.List;

// Problem: https://adventofcode.com/2025/day/1

public class DayOne2025 extends Puzzle {
    private int dialNumber = 50;

    public DayOne2025(String fileName) {
        super(fileName);
    }

    public DayOne2025(List<String> input) {
        super(input);
    }

    // Helper to update the position cleanly
    private void updatePosition(int change) {
        dialNumber = Math.floorMod(dialNumber + change, 100);
    }

    @Override
    public Object solvePart1() {
        // maintain count when dial hits zero
        dialNumber = 50;
        int answer = 0;

        for (var move : input) {
            boolean isLeft = move.charAt(0) == 'L';
            int dist = Integer.parseInt(move.substring(1));
            int turn = isLeft ? -dist : dist;

            updatePosition(turn);

            if (dialNumber == 0) {
                answer++;
            }
        }
        return answer;
    }

    @Override
    public Object solvePart2() {
        dialNumber = 50;
        int answer = 0;

        for (var move : input) {
            boolean isLeft = move.charAt(0) == 'L';
            int dist = Integer.parseInt(move.substring(1));

            // 1. Calculate Full Loops
            // Every 100 clicks guarantees passing 0 exactly once.
            answer += (dist / 100);

            // 2. Calculate the "Remainder" movement
            int remainder = dist % 100;

            // If there is no remainder, we are done with this move
            if (remainder == 0) continue;

            if (isLeft) {
                // Moving LEFT (subtracting)
                // We hit zero if the move pushes us down to 0 or below (mathematically).
                // CRITICAL EXCEPTION: If we START at 0, the first click takes us to 99.
                // We do not count that as "clicking onto 0".
                if (dialNumber != 0 && (dialNumber - remainder <= 0)) {
                    answer++;
                }
                // Update the dial position
                updatePosition(-remainder);
            } else {
                // Moving RIGHT (adding)
                // We hit zero if the move pushes us to 100 or above.
                if (dialNumber + remainder >= 100) {
                    answer++;
                }
                // Update the dial position
                updatePosition(remainder);
            }
        }
        return answer;
    }
}

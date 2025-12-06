package dev.ghidora.advent_of_java.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;

public abstract class Puzzle {
    protected String inputFilePath;
    public List<String> input;

    public Puzzle(String fileName) {
        try {
            inputFilePath = fileName;
            input = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println("Failed to read file");
        }
    }

    public abstract Object solvePart1();

    public abstract Object solvePart2();

    protected void measure(String label, Supplier<Object> solver) {
        long startTime = System.nanoTime();
        var result = solver.get();
        double duration = (System.nanoTime() - startTime) / 1_000_000.0;

        System.out.printf("%s : %s", label, result.toString());
        System.out.printf("Time: %.2f", duration);
    }

    public void solve() {
        System.out.println("-------");
        measure("Part 1", this::solvePart1);
        measure("Part 2", this::solvePart2);
        System.out.println("-------");
    }
}

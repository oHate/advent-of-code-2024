package dev.ohate.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("src/main/resources/day02.txt"));

        List<int[]> reports = new ArrayList<>();

        for (String line : input) {
            int[] report = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            reports.add(report);
        }

        int result = 0, dampenedResult = 0;

        for (int[] report : reports) {
            if (isReportSafe(report)) {
                result++;
                dampenedResult++;
            } else if (canBeMadeSafe(report)) {
                dampenedResult++;
            }
        }

        System.out.println("Day 2: Red-Nosed Reports");
        System.out.println("Part 1: " + result);
        System.out.println("Part 2: " + dampenedResult);
    }

    public static boolean canBeMadeSafe(int[] report) {
        for (int i = 0; i < report.length; i++) {
            int[] modifiedReport = new int[report.length - 1];

            System.arraycopy(report, 0, modifiedReport, 0, i);
            System.arraycopy(report, i + 1, modifiedReport, i, report.length - i - 1);

            if (isReportSafe(modifiedReport)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isReportSafe(int[] levels) {
        int[] differences = new int[levels.length - 1];

        for (int i = 0; i < levels.length - 1; i++) {
            differences[i] = levels[i + 1] - levels[i];
        }

        boolean positive = true;
        boolean negative = true;

        for (int diff : differences) {
            if (diff < 1 || diff > 3) {
                positive = false;
            }

            if (diff > -1 || diff < -3) {
                negative = false;
            }
        }

        return positive || negative;
    }

}

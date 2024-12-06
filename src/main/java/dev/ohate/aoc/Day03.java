package dev.ohate.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    private static final Pattern PATTERN = Pattern.compile("mul\\((\\d+),(\\d+)\\)|(do|don't)\\(\\)");

    public static void main(String[] args) throws IOException {
        String input = Files.readString(Path.of("src/main/resources/day03.txt"));

        boolean enabled = true;
        int result = 0, filteredResult = 0;

        Matcher matcher = PATTERN.matcher(input);

        while (matcher.find()) {
            String action = matcher.group(0);

            if (action.startsWith("mul")) {
                int firstNum = Integer.parseInt(matcher.group(1));
                int secondNum = Integer.parseInt(matcher.group(2));
                int product = firstNum * secondNum;

                result += product;

                if (enabled) {
                    filteredResult += product;
                }
            } else {
                enabled = !action.startsWith("don't");
            }
        }

        System.out.println("Day 3: Mull It Over");
        System.out.println("Part 1: " + result);
        System.out.println("Part 2: " + filteredResult);
    }

}

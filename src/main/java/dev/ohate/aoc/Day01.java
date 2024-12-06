package dev.ohate.aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day01 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        File file = new File("src/main/resources/day01.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split("\\s+");
            leftList.add(Integer.parseInt(input[0]));
            rightList.add(Integer.parseInt(input[1]));
        }

        scanner.close();

        leftList.sort(Integer::compareTo);
        rightList.sort(Integer::compareTo);

        int totalDistance = 0;

        for (int i = 0; i < leftList.size(); i++) {
            totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
        }

        System.out.println("Total Distance: " + totalDistance);

        Map<Integer, Integer> occurrenceMap = new HashMap<>();

        for (Integer num : rightList) {
            occurrenceMap.put(num, occurrenceMap.getOrDefault(num, 0) + 1);
        }

        int similarityScore = 0;

        for (Integer num : leftList) {
            similarityScore += num * occurrenceMap.getOrDefault(num, 0);
        }

        System.out.println("Day 1: Historian Hysteria");
        System.out.println("Part 1: " + totalDistance);
        System.out.println("Part 2: " + similarityScore);
    }

}
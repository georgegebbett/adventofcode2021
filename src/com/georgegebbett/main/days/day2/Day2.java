package com.georgegebbett.main.days.day2;

import com.georgegebbett.main.runner.ChristmasException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {

    public static void main() throws SubmarineException, ChristmasException {

        String inputFilePath = "/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day2/input.txt";

        System.out.println("Which part would you like to see?");

        String partChoice = new Scanner(System.in).nextLine();

        Submarine ourSub = new Submarine(inputFilePath);

        switch (partChoice) {
            case "1" -> System.out.printf("The part one answer is %d", ourSub.part1());
            case "2" -> System.out.printf("The part two answer is %d", ourSub.part2());
            default -> throw new ChristmasException("Choosing an invalid part isn't very Christmassy.");
        }

    }

}

class Submarine {
    private int depth = 0;
    private int horizontalPosition = 0;
    private final ArrayList<String> inputValues = new ArrayList<>();

    Submarine(String inputFilePath) throws SubmarineException {
        Scanner fileReader;
        try {
            fileReader = new Scanner(new File(inputFilePath));
        } catch (FileNotFoundException e) {
            throw new SubmarineException("File not found!");
        }
        while (fileReader.hasNextLine()) inputValues.add(fileReader.nextLine());
    }

    public int part1() throws SubmarineException {
        for (String instruction: inputValues) {
            String direction = instruction.split(" ")[0];
            int distance = Integer.parseInt(instruction.split(" ")[1]);

            switch (direction) {
                case "forward" -> horizontalPosition += distance;
                case "down" -> depth += distance;
                case "up" -> depth -= distance;
                default -> throw new SubmarineException("Invalid direction!");
            }
        }
        return depth * horizontalPosition;
    }

    public int part2() throws SubmarineException {
        int aim = 0;
        for (String instruction: inputValues) {
            String direction = instruction.split(" ")[0];
            int distance = Integer.parseInt(instruction.split(" ")[1]);

            switch (direction) {
                case "forward" -> {
                    horizontalPosition += distance;
                    depth += aim * distance;
                }
                case "down" -> aim += distance;
                case "up" -> aim -= distance;
                default -> throw new SubmarineException("Invalid direction!");
            }
        }
        return depth * horizontalPosition;
    }
}


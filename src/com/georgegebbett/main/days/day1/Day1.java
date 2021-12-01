package com.georgegebbett.main.days.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main() throws FileNotFoundException {

        String inputFilePath = "/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day1/input.txt";

        System.out.println("Which part would you like to see?");

        String partChoice = new Scanner(System.in).nextLine();

        SonarSweeper sweeper = new SonarSweeper(inputFilePath);

        switch (partChoice) {
            case "1" -> System.out.printf("There are %d increases in depth", sweeper.part1Depths());
            case "2" -> System.out.printf("There are %d increases in depth", sweeper.part2Depths());
            default -> System.out.println("NO!");
        }

    }

}

class SonarSweeper {

    private final ArrayList<Integer> inputValues = new ArrayList<>();
    private int increases = 0;

    SonarSweeper(String inputFilePath) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(inputFilePath));
        while (fileReader.hasNextLine()) inputValues.add(Integer.parseInt(fileReader.nextLine()));
    }

    public int part1Depths() {
        for (int x = 0; x < inputValues.size() - 1; x++) {
            if (inputValues.get(x) < inputValues.get(x + 1)) increases++;
        }

        return increases;

    }

    public int part2Depths() {
        for (int x = 1; x < inputValues.size() - 2; x++) {
            if (inputValues.get(x) + inputValues.get(x + 1) + inputValues.get(x + 2) > inputValues.get(x - 1) + inputValues.get(x) + inputValues.get(x + 1))
                increases++;
        }

        return increases;
    }

}
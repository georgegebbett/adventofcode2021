package com.georgegebbett.main.days.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main() throws FileNotFoundException {

        String inputFilePath = "/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day1/input.txt";

        Scanner optionReader = new Scanner(System.in);

        System.out.println("Which part would you like to see?");

        String partChoice = optionReader.nextLine();

        switch (partChoice) {
            case "1" -> {
                SonarSweeper part1Sweeper = new SonarSweeper(inputFilePath);
                System.out.printf("There are %d increases in depth", part1Sweeper.part1Depths());
            }
            case "2" -> {
                SonarSweeper part2Sweeper = new SonarSweeper(inputFilePath);
                System.out.printf("There are %d increases in depth", part2Sweeper.part2Depths());
            }
            default -> System.out.println("NO!");
        }


    }


}

class SonarSweeper {

    private File inputFile;
    private Scanner fileReader;

    SonarSweeper(String inputFilePath) throws FileNotFoundException {
        this.inputFile = new File(inputFilePath);
        if (!inputFile.exists()) throw new FileNotFoundException("Input file not found");
        this.fileReader = new Scanner(inputFile);
    }

    public int part1Depths() {

        int increases = 0;

        int lastDepth = Integer.parseInt(this.fileReader.nextLine());
        int currentDepth = Integer.parseInt(this.fileReader.nextLine());

        if (currentDepth > lastDepth) increases++;

        while (this.fileReader.hasNextLine()) {
            lastDepth = currentDepth;
            currentDepth = Integer.parseInt(this.fileReader.nextLine());
            if (currentDepth > lastDepth) increases++;
        }

        return increases;

    }

    public int part2Depths() {

        int increases = 0;

        ArrayList<Integer> measuringWindow = new ArrayList<>(3);

        measuringWindow.add(Integer.parseInt(this.fileReader.nextLine()));
        measuringWindow.add(Integer.parseInt(this.fileReader.nextLine()));
        measuringWindow.add(Integer.parseInt(this.fileReader.nextLine()));

        int lastSum = measuringWindow.get(0) + measuringWindow.get(1) + measuringWindow.get(2);

        measuringWindow.set(0, measuringWindow.get(1));
        measuringWindow.set(1, measuringWindow.get(2));
        measuringWindow.set(2, Integer.parseInt(this.fileReader.nextLine()));

        int currentSum = measuringWindow.get(0) + measuringWindow.get(1) + measuringWindow.get(2);

        if (currentSum > lastSum) increases++;

        while (this.fileReader.hasNextLine()) {
            lastSum = currentSum;

            measuringWindow.set(0, measuringWindow.get(1));
            measuringWindow.set(1, measuringWindow.get(2));
            measuringWindow.set(2, Integer.parseInt(this.fileReader.nextLine()));

            currentSum = measuringWindow.get(0) + measuringWindow.get(1) + measuringWindow.get(2);

            if (currentSum > lastSum) increases++;
        }

        return increases;

    }

}
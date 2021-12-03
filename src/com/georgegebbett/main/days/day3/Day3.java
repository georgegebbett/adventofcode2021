package com.georgegebbett.main.days.day3;

import com.georgegebbett.main.runner.ChristmasException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {

    public static void main() throws ChristmasException, FileNotFoundException {

        String inputFilePath = "/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day3/input.txt";

        System.out.println("Which part would you like to see?");

        String partChoice = new Scanner(System.in).nextLine();

        DiagnosticInterpreter diagIn = new DiagnosticInterpreter(inputFilePath);

        switch (partChoice) {
            case "1" -> System.out.printf("The part one answer is %s", diagIn.part1());
            case "2" -> System.out.printf("The part two answer is %s", diagIn.part2());
            default -> throw new ChristmasException("Choosing an invalid part isn't very Christmassy.");
        }

    }

}


class DiagnosticInterpreter {
    private final ArrayList<String> inputValues = new ArrayList<>();
    private String leastCommon;
    private String mostCommon;
    private ArrayList<HashMap<String, Integer>> valueFrequency = new ArrayList<>();


    DiagnosticInterpreter(String inputFilePath) throws FileNotFoundException {
        Scanner fileReader;
        fileReader = new Scanner(new File(inputFilePath));
        while (fileReader.hasNextLine()) inputValues.add(fileReader.nextLine());

        calculateValueFrequency(inputValues);
    }

    private void calculateValueFrequency(ArrayList<String> inputValues) {
        valueFrequency = new ArrayList<>();
        StringBuilder gamma = new StringBuilder();
        for (int i = 0; i < inputValues.get(0).length(); i++) {
            valueFrequency.add(i, new HashMap<>());
            for (String currentValue: inputValues) {
                valueFrequency.get(i).putIfAbsent(currentValue.substring(i, i+1), 0);
                valueFrequency.get(i).computeIfPresent(currentValue.substring(i, i+1), (key, val) -> val + 1);
            }
            valueFrequency.get(i).putIfAbsent("0", 0);
            valueFrequency.get(i).putIfAbsent("1", 0);
            if (valueFrequency.get(i).get("1") > valueFrequency.get(i).get("0")) gamma.append("1");
            else gamma.append("0");

            StringBuilder epsilon = new StringBuilder();
            for (char c: gamma.toString().toCharArray()) {
                if (c == '1') epsilon.append("0");
                else epsilon.append("1");
            }

            mostCommon = gamma.toString();
            leastCommon = epsilon.toString();
        }
    }

    public int part1() {
        return Integer.parseInt(mostCommon, 2) * Integer.parseInt(leastCommon, 2);
    }

    public int part2() {
        ArrayList<String> oxygenList = new ArrayList<>(inputValues);
        ArrayList<String> co2List = new ArrayList<>(inputValues);
        ArrayList<String> workingList = new ArrayList<>();

        for (int i = 0; i < oxygenList.get(0).length(); i++) {
            for (String currentValue: oxygenList) {
                boolean isOne = currentValue.charAt(i) == '1';
                if (isOne) {
                    if (valueFrequency.get(i).get("1") >= valueFrequency.get(i).get("0") && !workingList.contains(currentValue)) {
                        workingList.add(currentValue);
                    } else {
                        workingList.remove(currentValue);
                    }
                } else if (valueFrequency.get(i).get("0") > valueFrequency.get(i).get("1") && !workingList.contains(currentValue)) {
                    workingList.add(currentValue);
                }  else workingList.remove(currentValue);
            }
            oxygenList = workingList;
            if (oxygenList.size() == 1) break;
            calculateValueFrequency(oxygenList);
            workingList = new ArrayList<>();
        }
        int oxygen = Integer.parseInt(oxygenList.get(0), 2);

        for (int i = 0; i < co2List.get(0).length(); i++) {
            for (String currentValue: co2List) {
                boolean isOne = currentValue.charAt(i) == '1';
                if (isOne) {
                    if (valueFrequency.get(i).get("1") < valueFrequency.get(i).get("0") && !workingList.contains(currentValue)) {
                        workingList.add(currentValue);
                    } else {
                        workingList.remove(currentValue);
                    }
                } else if (valueFrequency.get(i).get("0") <= valueFrequency.get(i).get("1") && !workingList.contains(currentValue)) {
                    workingList.add(currentValue);
                }  else workingList.remove(currentValue);
            }
            co2List = workingList;
            if (co2List.size() == 1) break;
            calculateValueFrequency(co2List);
            workingList = new ArrayList<>();
        }

        int co2 = Integer.parseInt(co2List.get(0), 2);

        return oxygen * co2;
    }
}
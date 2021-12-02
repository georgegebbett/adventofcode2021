package com.georgegebbett.main.runner;

import com.georgegebbett.main.days.day1.Day1;
import com.georgegebbett.main.days.day2.Day2;
import com.georgegebbett.main.days.day2.SubmarineException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ChristmasException, FileNotFoundException, SubmarineException {
	    System.out.println("Welcome to my attempt at Advent of Code 2021!");
        System.out.println("Which day would you like to see?");

        Scanner inputReader = new Scanner(System.in);
        String dayChoice = inputReader.nextLine();

        switch (dayChoice) {
            case "1" -> Day1.main();
            case "2" -> Day2.main();
            default -> throw new ChristmasException("Choosing an invalid day isn't very christmassy of you");
        }
    }
}

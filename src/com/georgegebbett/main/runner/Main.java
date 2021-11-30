package com.georgegebbett.main.runner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
	    System.out.println("Welcome to my attempt at Advent of Code 2021!");
        System.out.println("Which day would you like to see?");

        Scanner inputReader = new Scanner(System.in);
        String dayChoice = inputReader.nextLine();

        switch (dayChoice) {
            default:
                throw new NoSuchMethodException("That is not a valid day");
        }
    }
}

package com.georgegebbett.main.days.day1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SonarSweeperTest {

    @Test
    void part1Depths() throws FileNotFoundException {
        SonarSweeper testSweeper = new SonarSweeper("/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day1/testInput.txt");

        assertEquals(testSweeper.part1Depths(), 7);

    }

    @Test
    void part2Depths() throws FileNotFoundException {
        SonarSweeper testSweeper = new SonarSweeper("/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day1/testInput.txt");

        assertEquals(testSweeper.part2Depths(), 5);
    }
}
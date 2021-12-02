package com.georgegebbett.main.days.day2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SubmarineTest {

    @Test
    @DisplayName("1. Part 1 returns 150 with test input")
    void Part1Returns150WithTestInput() throws SubmarineException {
        Submarine testSub = new Submarine("/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day2/testInput.txt");
        assertEquals(testSub.part1(), 150);
    }

    @Test
    @DisplayName("2. Part 2 returns 900 with test input")
    void Part2Returns900WithTestInput() throws SubmarineException {
        Submarine testSub = new Submarine("/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day2/testInput.txt");
        assertEquals(testSub.part2(), 900);
    }

    @Test
    @DisplayName("3. Creating a Submarine with an invalid file results in a SubmarineException")
    void CreatingSubmarineWithInvalidFileResultsInSubmarineException() {
        assertThrows(SubmarineException.class, () -> new Submarine("invalid path"));
    }

    @Test
    @DisplayName("4. Running the parts on a file with an invalid direction results in a SubmarineException")
    void invalidDirectionTest() throws SubmarineException {
        Submarine badSub = new Submarine("/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day2/badInput.txt");
        assertThrows(SubmarineException.class, badSub::part1);
        assertThrows(SubmarineException.class, badSub::part2);
    }
}
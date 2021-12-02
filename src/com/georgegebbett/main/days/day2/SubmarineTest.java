package com.georgegebbett.main.days.day2;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SubmarineTest {

    @Test
    void part1() throws SubmarineException {
        Submarine testSub = new Submarine("/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day2/testInput.txt");
        assertEquals(testSub.part1(), 150);
    }

    @Test
    void part2() throws SubmarineException {
        Submarine testSub = new Submarine("/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day2/testInput.txt");
        assertEquals(testSub.part2(), 900);
    }

    @Test
    void invalidFile() {
        assertThrows(SubmarineException.class, () -> new Submarine("invalid path"));
    }
}
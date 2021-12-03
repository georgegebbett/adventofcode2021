package com.georgegebbett.main.days.day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DiagnosticInterpreterTest {

    String testFilePath = "/Users/george/IdeaProjects/adventofcode2021/src/com/georgegebbett/main/days/day3/testInput.txt";

    @Test
    @DisplayName("Part one returns 198 with test input")
    void part1() throws FileNotFoundException {
        DiagnosticInterpreter testDiag = new DiagnosticInterpreter(testFilePath);
        assertEquals(198, testDiag.part1());
    }

    @Test
    @DisplayName("Part two returns 230 with test input")
    void part2() throws FileNotFoundException {
        DiagnosticInterpreter testDiag = new DiagnosticInterpreter(testFilePath);
        assertEquals(230, testDiag.part2());
    }
}
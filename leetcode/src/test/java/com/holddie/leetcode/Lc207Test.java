package com.holddie.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc207Test {

    private Lc207 lc207UnderTest;

    @BeforeEach
    void setUp() {
        lc207UnderTest = new Lc207();
    }

    @Test
    void testCanFinish() {
        // Setup
        final int[][] prerequisites = new int[][] {{1, 0}};
        int numCourses = 2;

        // Run the test
        final boolean result = lc207UnderTest.canFinish(numCourses, prerequisites);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCanFinish1() {
        // Setup
        final int[][] prerequisites = new int[][] {{1, 0}, {0, 1}};
        int numCourses = 2;

        // Run the test
        final boolean result = lc207UnderTest.canFinish(numCourses, prerequisites);

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testCanFinishWayTwo() {
        // Setup
        final int[][] prerequisites = new int[][] {{1, 0}};
        int numCourses = 2;

        // Run the test
        final boolean result = lc207UnderTest.canFinishWayTwo(numCourses, prerequisites);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCanFinishWayTwo1() {
        // Setup
        final int[][] prerequisites = new int[][] {{1, 0}, {0, 1}};
        int numCourses = 2;

        // Run the test
        final boolean result = lc207UnderTest.canFinishWayTwo(numCourses, prerequisites);

        // Verify the results
        assertFalse(result);
    }
}

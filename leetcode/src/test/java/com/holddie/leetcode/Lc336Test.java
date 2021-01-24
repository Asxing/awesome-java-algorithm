package com.holddie.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc336Test {

    private Lc336 lc336UnderTest;

    @BeforeEach
    void setUp() {
        lc336UnderTest = new Lc336();
    }

    @Test
    void testPalindromePairs() {
        // Setup
        String[] words = new String[] {"abcd", "dcba", "lls", "s", "sssll"};
        final List<List<Integer>> expectedResult =
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0),
                        Arrays.asList(3, 2),
                        Arrays.asList(2, 4));

        // Run the test
        final List<List<Integer>> result = lc336UnderTest.palindromePairs(words);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testPalindromePairs1() {
        // Setup
        String[] words = new String[] {"abcd", "dcba", "lls", "s", "sssll"};
        final List<List<Integer>> expectedResult =
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0));

        // Run the test
        final List<List<Integer>> result = lc336UnderTest.palindromePairs(words);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}

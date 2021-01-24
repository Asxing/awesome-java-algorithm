package com.holddie.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Mst0803Test {

    private Mst0803 mst0803UnderTest;

    @BeforeEach
    void setUp() {
        mst0803UnderTest = new Mst0803();
    }

    @Test
    void testFindMagicIndex() {
        // Setup
        int[] nums = new int[] {0, 2, 3, 4, 5};

        // Run the test
        final int result = mst0803UnderTest.findMagicIndex(nums);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testFindMagicIndex1() {
        // Setup
        int[] nums = new int[] {1, 1, 1};

        // Run the test
        final int result = mst0803UnderTest.findMagicIndex(nums);

        // Verify the results
        assertEquals(1, result);
    }

    @Test
    void testFindMagicIndexWay1() {
        // Setup
        int[] nums = new int[] {1, 1, 1};
        // Run the test
        final int result = mst0803UnderTest.findMagicIndexWay1(nums);

        // Verify the results
        assertEquals(1, result);
    }

    @Test
    void testFindMagicIndexWay11() {
        // Setup
        int[] nums = new int[] {0, 2, 3, 4, 5};
        // Run the test
        final int result = mst0803UnderTest.findMagicIndexWay1(nums);

        // Verify the results
        assertEquals(0, result);
    }
}

package com.holddie.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc392Test {

    private final Lc392 lc392UnderTest = new Lc392();

    @Test
    public void testIsSubsequence() {
        // Setup
        String s = "abc";
        String t = "ahbgdc";

        // Run the test
        final boolean result = lc392UnderTest.isSubsequence(s, t);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testIsSubsequenceWay1() {
        // Setup
        String s = "abc";
        String t = "ahbgdc";

        // Run the test
        final boolean result = lc392UnderTest.isSubsequenceWay1(s, t);

        // Verify the results
        assertTrue(result);
    }
}

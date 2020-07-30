package com.holddie.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc343Test {
	Lc343 lc343;
	int n;

	@BeforeEach
	void setUp() {
		lc343 = new Lc343();
	}

	@Test
	void testIntegerBreak() {
		// Setup
		n = 2;

		// Run the test
		final int result = lc343.integerBreak(n);

		// Verify the results
		assertEquals(1, result);
	}

	@Test
	void testIntegerBreak1() {
		// Setup
		n = 10;

		// Run the test
		final int result = lc343.integerBreak(n);

		// Verify the results
		assertEquals(36, result);
	}
}


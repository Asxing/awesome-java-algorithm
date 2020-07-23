package com.holddie.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc064Test {

	private Lc064 lc064UnderTest;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		lc064UnderTest = new Lc064();
	}

	@org.junit.jupiter.api.AfterEach
	void tearDown() {
	}

	@Test
	void testMinPathSum() {
		// Setup
		final int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

		// Run the test
		final int result = lc064UnderTest.minPathSum(grid);

		// Verify the results
		assertEquals(7, result);
	}


	@Test
	void testMinPathSumWay1() {
		// Setup
		final int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

		// Run the test
		final int result = lc064UnderTest.minPathSumWay1(grid);

		// Verify the results
		assertEquals(7, result);
	}
}

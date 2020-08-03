package com.holddie.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc415Test {

	private Lc415 lc415UnderTest;
	private String num1;
	private String num2;

	@BeforeEach
	void setUp() {
		lc415UnderTest = new Lc415();
	}

	@Test
	void testAddStrings() {
		// Setup
		num1 = "1";
		num2 = "9";


		// Run the test
		final String result = lc415UnderTest.addStrings(num1, num2);
		final String result1 = lc415UnderTest.addStringsWayOne(num1, num2);

		// Verify the results
		assertEquals("10", result);
		assertEquals("10", result1);
	}

	@Test
	void testAddStrings1() {
		// Setup
		num1 = "99";
		num2 = "9";

		// Run the test
		final String result = lc415UnderTest.addStrings(num1, num2);
		final String result1 = lc415UnderTest.addStringsWayOne(num1, num2);

		// Verify the results
		assertEquals("108", result);
		assertEquals("108", result1);
	}
}

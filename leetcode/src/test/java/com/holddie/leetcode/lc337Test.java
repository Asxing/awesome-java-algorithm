package com.holddie.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class lc337Test {

	private Lc337 lc337UnderTest;

	@BeforeEach
	void setUp() {
		lc337UnderTest = new Lc337();
	}

	@Test
	void testRob() {
		// Setup
		final TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(1);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setRight(node3);
		node2.setRight(node4);

		// Run the test
		final int result = lc337UnderTest.rob(root);

		// Verify the results
		assertEquals(7, result);
	}

	@Test
	void testRob1() {
		// Setup
		final TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(1);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setRight(node5);

		// Run the test
		final int result = lc337UnderTest.rob(root);

		// Verify the results
		assertEquals(9, result);
	}
}

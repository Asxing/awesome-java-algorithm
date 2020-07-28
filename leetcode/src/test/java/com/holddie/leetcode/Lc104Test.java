package com.holddie.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lc104Test {
	Lc104 lc104 = new Lc104();

	private Lc104.TreeNode treeNode;

	@BeforeEach
	void setUp() {
		treeNode = new Lc104.TreeNode(3);
		Lc104.TreeNode treeNode1 = new Lc104.TreeNode(9);
		Lc104.TreeNode treeNode2 = new Lc104.TreeNode(20);
		Lc104.TreeNode treeNode3 = new Lc104.TreeNode(15);
		Lc104.TreeNode treeNode4 = new Lc104.TreeNode(7);
		treeNode2.left = treeNode3;
		treeNode2.right = treeNode4;
		treeNode.left = treeNode1;
		treeNode.right = treeNode2;
	}

	@Test
	void testMaxDepth() {
		int result = lc104.maxDepth(treeNode);
		Assertions.assertEquals(3, result);
	}

	@Test
	void testMaxDepth1() {
		int result = lc104.maxDepthWay1(treeNode);
		Assertions.assertEquals(3, result);
	}


}

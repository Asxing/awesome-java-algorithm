package com.holddie.e14_backtracking;

public class EightQueueDemo {

	public static void main(String[] args) {
		EightQueueDemo queue = new EightQueueDemo();
		queue.check(0);
		System.out.println("一共有<" + queue.count + ">种解法, 并且要循环<" + queue.loopCount + ">次");
	}

	/**
	 * 八皇后数组，下脚标代表行， 数值代表列
	 */
	int arr[] = new int[8];

	/**
	 * 一共有多少种解法
	 */
	int count = 0;

	/**
	 * 求出所有结果需要遍历多少次
	 */
	int loopCount = 0;

	public void check(int n) {
		if (n == 8) {
			print();
			count++;
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[n] = i;
			if (ifSatisfied(n)) {
				check(n + 1);
			}
		}
	}

	/**
	 * 判断当前的方法是否合乎八皇后的逻辑
	 */
	public boolean ifSatisfied(int n) {
		loopCount++;
		for (int i = 0; i < n; i++) {
			// 判断不在一列和不在一个对角线上（对角上的书行相减的绝对值等于列相减的绝对值）
			if (arr[i] == arr[n] || Math.abs(arr[i] - arr[n]) == Math.abs(i - n)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 打印八皇后问题的解法
	 */
	public void print() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
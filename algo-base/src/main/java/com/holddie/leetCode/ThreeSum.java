package com.holddie.leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        System.out.println(threeSum(nums, 4));
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num.length < 3 || num == null) {
            return res;
        }
        Arrays.sort(num);
        for (int i = 0; i <= num.length - 3; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                int low = i + 1;
                int high = num.length - 1;
                while (low < high) {
                    int sum = num[i] + num[low] + num[high];
                    if (sum == target) {
                        ArrayList<Integer> unit = new ArrayList<>();
                        unit.add(num[i]);
                        unit.add(num[low]);
                        unit.add(num[high]);
                        res.add(unit);
                        low++;
                        high--;

                        while (low < high && num[low] == num[low - 1]) {
                            low++;
                        }
                        while (low < high && num[high] == num[high + 1]) {
                            high--;
                        }
                    } else if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return res;
    }
}

package com.holddie.e06_sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    private static void quickSortInternally(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(nums, low, high);
        quickSortInternally(nums, low, pivot - 1);
        quickSortInternally(nums, pivot + 1, high);
    }

    // 快排核心
    private static int partition(int[] nums, int low, int high) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] < nums[high]) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {22, 12, 34, 25, 41, 29};
        quickSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}

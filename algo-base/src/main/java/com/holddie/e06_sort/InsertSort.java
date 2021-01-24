package com.holddie.e06_sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] data = new int[] {4, 6, 5, 3, 7, 1, 2};
        insertSort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void insertSort(int[] data) {
        int length = data.length;
        if (length > 0) {
            for (int i = 1; i < length; i++) {
                int temp = data[i];
                int j = i;
                for (; j > 0 && data[j - 1] > temp; j--) {
                    data[j] = data[j - 1];
                }
                data[j] = temp;
            }
        }
    }
}

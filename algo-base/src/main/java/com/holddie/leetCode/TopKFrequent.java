package com.holddie.leetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> oc = new HashMap<>();
        for (int num : nums) {
            oc.put(num, oc.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((m, n) -> (m[1] - n[1]));

        for (Map.Entry<Integer, Integer> entry : oc.entrySet()) {
            int num = entry.getKey(), value = entry.getValue();
            if (queue.size() == k) {
                assert queue.peek() != null;
                if (queue.peek()[1] < value) {
                    queue.poll();
                    queue.offer(new int[]{num, value});
                }
            } else {
                queue.offer(new int[]{num, value});
            }
        }
        int len = Math.min(queue.size(), k);
        int[] num = new int[len];
        for (int i = 0; i < queue.size(); ++i) {
            num[i] = queue.poll()[0];
        }
        return num;
    }

}

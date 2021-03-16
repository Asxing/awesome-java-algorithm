package com.holddie.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(
            int[] candidates,
            int target,
            List<List<Integer>> res,
            int i,
            ArrayList<Integer> tmpList) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            System.out.println(start);
            tmpList.add(candidates[start]);
            System.out.println(tmpList);
            backtrack(candidates, target - candidates[start], res, start, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}

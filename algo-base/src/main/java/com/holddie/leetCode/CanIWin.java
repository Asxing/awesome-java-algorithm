package com.holddie.leetCode;

import java.util.Arrays;
import java.util.HashMap;

public class CanIWin {
    /**
     * 记忆化回溯（也称为递归+备忘录），自顶向下 采用记忆化后的时间复杂度为O(2^n)(如果不进行记忆的话，时间复杂度将是O(n!))，可以理解为已经缩成了只有一个分支了
     * 然后为什么要进行记忆化： 因为我们发现，例如[2,3]和[3,2]之后的玩家选择状态都是一样的，都是可以从除了2,3之外的
     * 数字进行选择，那么就可以对选择2和3后第一个玩家能不能赢进行记忆存储 这里采用state[]数组存储每个数字是否都被选过，选过则记录为1，然后我们将state.toString()
     * 使得[2,3]和[3,2]它们的结果都是一样的"0011"，作为key，存储在HashMap中，value是选了2和3 之后第一个玩家是否稳赢
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
            return false; // 1,..maxChoosable数列总和都比目标和小
        int[] state = new int[maxChoosableInteger + 1]; // state[1]=1表示1被选了
        return backtraceWitMemo(state, desiredTotal, new HashMap<String, Boolean>());
    }

    private boolean backtraceWitMemo(int[] state, int desiredTotal, HashMap<String, Boolean> map) {
        String key = Arrays.toString(state); // 这里比较关键，如何表示这个唯一的状态，例如[2,3]和[3,2]都是"0011"，状态一样
        if (map.containsKey(key))
            return map.get(key); // 如果已经记忆了这样下去的输赢结果,记忆是为了防止如[2,3]，[3,2]之后的[1,4,5,..]这个选择区间被重复计算

        for (int i = 1; i < state.length; i++) {
            if (state[i] == 0) { // 如果这个数字i还没有被选中
                state[i] = 1;
                // 如果当前选了i已经赢了或者选了i还没赢但是后面对方选择输了
                if (desiredTotal - i <= 0 || !backtraceWitMemo(state, desiredTotal - i, map)) {
                    map.put(key, true);
                    state[i] = 0; // 在返回之前回溯
                    return true;
                }
                // 如果不能赢也要记得回溯
                state[i] = 0;
            }
        }
        // 如果都赢不了
        map.put(key, false);
        return false;
    }

    /**
     * 依据上面的思路 一个数字就选或者不选两个状态，就可以用整形来表示 比如1 2 3 4中 选1 2 3 --> 0111 --> 7 选1 3 2 --> 0111 --> 7
     * 最大是1111 -> 15 即 (1 << 4) - 1 1 << 0表示1选了 1 << 1表示2选了 1 << 3表示3选了 用 | 运算累加选的就能记录状态 此时就可以用dp数组
     * dp + 状态压缩
     */
    public boolean canIWin3(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        Boolean[] dp = new Boolean[(1 << maxChoosableInteger) - 1];
        return recur3(maxChoosableInteger, desiredTotal, dp, 0);
    }

    private boolean recur3(int maxChoosableInteger, int desiredTotal, Boolean[] dp, int state) {
        if (dp[state] != null) return dp[state];
        if (desiredTotal <= 0) {
            dp[state] = false;
            return false;
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int cur = 1 << i - 1;
            // 如0011 & 0100  如果没选  肯定为0  如果选了0011 & 0001  肯定不为0
            if ((state & cur) != 0) continue;
            boolean last = recur3(maxChoosableInteger, desiredTotal - i, dp, state | cur);
            if (!last) {
                dp[state] = true;
                return true;
            }
        }
        dp[state] = false;
        return false;
    }
}

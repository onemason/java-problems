package io.github.ryan.algo.easy;

import java.util.HashMap;

public class SumSolution {

    /**
     * 两数之和 LeetCode 01
     * 思想: 空间换时间
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }

}

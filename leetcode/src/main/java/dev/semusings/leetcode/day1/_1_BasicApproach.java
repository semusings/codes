package dev.semusings.leetcode.day1;

/*

Idea: Try every possible pair in the array and check if their sum equals the target.

Time Complexity: O(n²), since there are two nested loops.

 */
public class _1_BasicApproach {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;

                int element1 = nums[i];

                int element2 = nums[j];

                if (element1 + element2 == target) {
                    return new int[]{i, j};
                }

            }
        }

        return null;
    }


}

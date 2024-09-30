package dev.semusings.leetcode.p001;

import java.util.Arrays;

/*

Idea: If the array is sorted, you can use two pointers: one starting at the beginning and one at the end.
If the sum of the two pointed elements is larger than the target, move the end pointer inward.
If the sum is smaller, move the start pointer inward.

Time Complexity: O(n), since you're only making one pass through the array. However, the array must be sorted first, which takes O(n log n).

 */
public class _4_UsingTwoPointersApproach {

    public int[] twoSum(int[] nums, int target) {

        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pairs, (o1, o2) -> o1.value - o2.value);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = pairs[left].value + pairs[right].value;
            if (sum == target) {
                return new int[]{pairs[left].index, pairs[right].index};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }

    public record Pair(int value, int index) {

    }


}

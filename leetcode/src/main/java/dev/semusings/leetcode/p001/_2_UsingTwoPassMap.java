package dev.semusings.leetcode.p001;

import java.util.HashMap;

/*

Idea: Use a hash map to store each element's value and its index.
In the first pass, store all the elements, and in the second pass,
check if the complement of the current element (i.e., target - nums[i]) exists in the map.

Time Complexity: O(n) for building the hash map and O(n) for searching, so overall O(n).

 */
public class _2_UsingTwoPassMap {

    public int[] twoSum(int[] nums, int target) {

        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];

            int complement = target - current;

            Integer indexOfComplement = map.get(complement);

            if (indexOfComplement != null && indexOfComplement != i) {
                return new int[]{i, indexOfComplement};
            }

        }

        return null;
    }


}

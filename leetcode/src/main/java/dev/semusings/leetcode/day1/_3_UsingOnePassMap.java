package dev.semusings.leetcode.day1;

import java.util.HashMap;

/*

Idea: Combine the storage and search in one pass.
As you iterate through the array, for each element, check if its complement is already in the hash map.
If it is, you have found the solution. Otherwise, store the element in the hash map.

Time Complexity: O(n), since you make only one pass through the array and each look-up in the hash map is O(1).

 */
public class _3_UsingOnePassMap {

    public int[] twoSum(int[] nums, int target) {

        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];

            int complement = target - current;

            Integer indexOfComplement = map.get(complement);

            if (indexOfComplement != null) {
                return new int[]{indexOfComplement, i};
            }

            map.put(current, i);

        }

        return null;
    }


}

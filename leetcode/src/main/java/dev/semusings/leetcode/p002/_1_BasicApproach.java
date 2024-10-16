package dev.semusings.leetcode.p002;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*

Idea:
- Iterate over each character in the string.
- For each character,
  check if it exists in the uniqueList which stores the current substring with unique characters.
- If a duplicate character is found,
  update the maximum length and reset the uniqueList for the next potential substring.

Time Complexity:
- O(n²): The outer loop iterates over each character (O(n)), and for each character,
  the inner loop checks for duplicates in the uniqueSet (O(n) in the worst case).
  Hence, the overall time complexity is O(n²).

 */
public class _1_BasicApproach {

  public int lengthOfLongestSubstring(String s) {
    char[] chars = s.toCharArray();
    Set<Character> uniqueSet = new HashSet<>();
    int maxLen = 0;
    for (Character current : chars) { // O(n)
      for (Character currentUnique : uniqueSet) { // O(n)
        if (currentUnique.equals(current)) {
          int currentSize = uniqueSet.size();
          if (currentSize > maxLen) {
            maxLen = currentSize;
          }
          uniqueSet.clear();
        }
      }
      uniqueSet.add(current);
    }
    return maxLen;
  }

}

package dev.semusings.leetcode.p002;

import java.util.LinkedList;
import java.util.List;

/*

Idea:
- Use a sliding window technique with two pointers (start and end) to represent the current substring,
  and a HashSet to track unique characters.
- Move the end pointer to expand the window, and if a repeating character is found,
  remove characters from the start pointer until the substring becomes unique again.

Time Complexity:
- O(n): Each character is processed at most twice, once by the end pointer and once by
  the start pointer, resulting in linear time.

 */
public class _1_SlidingWindowWithHashSet {

  public int lengthOfLongestSubstring(String s) {
    int start = 0;
    int end = 0;
    List<Character> uniqueSet = new LinkedList<>();
    int maxLen = 0;
    while (end < s.length()) {
      char charAtEnd = s.charAt(end);
      while (uniqueSet.contains(charAtEnd)) {
        uniqueSet.remove(s.charAt(start));
        start++;
      }
      uniqueSet.add(charAtEnd);
      maxLen = Math.max(maxLen, end - start + 1);
      end++;
    }

    return maxLen;
  }

}

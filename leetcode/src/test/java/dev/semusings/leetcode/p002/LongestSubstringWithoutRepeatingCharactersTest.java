package dev.semusings.leetcode.p002;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestSubstringWithoutRepeatingCharactersTest {

    //@formatter:off
  private static Stream<Arguments> provider() {
    return Stream.of(
        Arguments.of("abcabcbb", 3),
        Arguments.of("bbbbb", 1),
        Arguments.of("pwwkew", 3)
    );
  }
  //@formatter:on

    @ParameterizedTest
    @MethodSource("provider")
    void test(String s, int expected) {
        Assertions.assertEquals(expected, new _1_BasicApproach().lengthOfLongestSubstring(s));
    }

}
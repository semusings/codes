package dev.semusings.leetcode.p001;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSumSolutionTest {

    //@formatter:off
  private static Stream<Arguments> provider() {
    return Stream.of(
        Arguments.of(new int[]{2,7,11,15}, 9, new int[]{0, 1}),
        Arguments.of(new int[]{3,2,4}, 6, new int[]{1, 2}),
        Arguments.of(new int[]{3,3}, 6, new int[]{0, 1})
    );
  }
  //@formatter:on

    @ParameterizedTest
    @MethodSource("provider")
    void test(int[] nums, int target, int[] expected) {
        Assertions.assertArrayEquals(expected, new _1_BasicApproach().twoSum(nums, target));
        Assertions.assertArrayEquals(expected, new _2_UsingTwoPassMap().twoSum(nums, target));
        Assertions.assertArrayEquals(expected, new _3_UsingOnePassMap().twoSum(nums, target));
        Assertions.assertArrayEquals(expected, new _4_UsingTwoPointersApproach().twoSum(nums, target));
    }

}
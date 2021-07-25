package com.github.git_leon.onlineassessment;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Result2Test {
    @Test
    public void test() {
        // given
        List<Integer> consecutiveDifference = Arrays.asList(-2,-1,-2,5);
        int lowerBound = 3;
        int upperBound = 10;
        Result2 result2 = new Result2(consecutiveDifference, lowerBound, upperBound);
        int expected = 3;

        // when
        int actual = result2.solve();

        // then
        Assert.assertEquals(expected, actual);
    }
}

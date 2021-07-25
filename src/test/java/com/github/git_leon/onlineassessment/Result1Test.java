package com.github.git_leon.onlineassessment;

import org.junit.Assert;
import org.junit.Test;

public class Result1Test {
    @Test
    public void test() {
        // given
        Result1 solution = new Result1(10,4,-8,7);
        int expected = 3;

        // when
        int actual  = solution.solve();

        // then
        Assert.assertEquals(expected, actual);
    }
}

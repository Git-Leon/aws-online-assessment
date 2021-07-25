package com.github.git_leon.onlineassessment;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        // given
        Solution solution = new Solution(10,4,-8,7);
        int expected = 3;

        // when
        int actual  = solution.solve();

        // then
        Assert.assertEquals(expected, actual);
    }
}

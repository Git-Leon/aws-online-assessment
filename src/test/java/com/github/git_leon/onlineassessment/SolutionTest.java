package com.github.git_leon.onlineassessment;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        // given
        Solution solution = new Solution();

        // when
        String actual = solution.toString();

        // then
        Assert.assertNotNull(actual);
    }
}

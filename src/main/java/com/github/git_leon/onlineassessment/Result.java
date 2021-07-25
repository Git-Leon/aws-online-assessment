package com.github.git_leon.onlineassessment;

import java.util.List;



class Result {
    // migrating to local IDE
    List<Integer> consecutiveDifference;
    int lowerBound;
    int upperBound;

    public Result(List<Integer> consecutiveDifference, int lowerBound, int upperBound){
        this.consecutiveDifference = consecutiveDifference;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Integer solve() {
        return null;
    }
    /*
     * Complete the 'countAnalogousArrays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY consecutiveDifference
     *  2. INTEGER lowerBound
     *  3. INTEGER upperBound
     */

    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
        return new Result(consecutiveDifference, lowerBound, upperBound).solve();
    }

}
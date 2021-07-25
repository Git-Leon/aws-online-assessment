package com.github.git_leon.onlineassessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Result2 {
    List<Integer> consecutiveDifference;
    int lowerBound;
    int upperBound;

    public Result2(List<Integer> secretConsecutiveDelta, int lowerBound, int upperBound) {
        this.consecutiveDifference = secretConsecutiveDelta;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    private boolean isSameLength(List<Integer> arr) {
        return this.consecutiveDifference.size() == arr.size();
    }

    private boolean isInRange(int value) {
        return value > lowerBound && value < upperBound;
    }

    private boolean isInRange(List<Integer> arr) {
        Collections.sort(arr);
        for(int i =0; i< arr.size(); i++) {
            int j = (arr.size()-1) - i; // iterating backwards
            int head = arr.get(i);
            int tail = arr.get(j);
            boolean isInRange = isInRange(head) && isInRange(tail);
            if(!isInRange) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> createAnalogousArray(int lowerBound) {
        Integer[] analogousArr = new Integer[this.consecutiveDifference.size()];
        analogousArr[0] = lowerBound;
        for (int i = 1; i < analogousArr.length; i++) {
            analogousArr[i] = analogousArr[i-1] - consecutiveDifference.get(i-1);
            int currentElement = analogousArr[i];
            if(!isInRange(currentElement)) {
                return null;
            }
        }
        return Arrays.asList(analogousArr);
    }

    private List<List<Integer>> createAllAnalogousArrays() {
        List<List<Integer>> result = new ArrayList<>();
        int lowerBound = this.lowerBound;
        List<Integer> analogousArr = null;
        do {
            analogousArr = createAnalogousArray(lowerBound);
            lowerBound = analogousArr.get(0);
            result.add(analogousArr);
        } while(analogousArr != null);
        result.remove(null);
        return result;
    }

    public Integer solve() {
        return createAllAnalogousArrays().size();
    }

    public static Integer countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
        return new Result2(consecutiveDifference, lowerBound, upperBound).solve();
    }

}
package com.github.git_leon.onlineassessment;

import java.util.*;

class Result1 { // moving to do debugging on local IDE
    class Pair<K,V> {
        private K key;
        private V value;
        public Pair(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private List<Integer> arr;

    public Result1(Integer... arr) {
        this(Arrays.asList(arr));
    }

    public Result1(List<Integer> arr) {
        this.arr = arr;
    }

    public Set<List<Integer>> getAllPermutations(List<Integer> list) {
        Set<List<Integer>> sets = new LinkedHashSet<>();
        if(this.arr.isEmpty()) {
            sets.add(new ArrayList<>());
            return sets;
        }
        Integer head = list.get(0);
        List<Integer> tail =list.subList(1, list.size());
        for(List<Integer> permutationOfTail :  getAllPermutations(tail)) {
            List<Integer> newList = new ArrayList<>();
            newList.add(head);
            newList.addAll(tail);
            sets.add(newList);
            sets.add(permutationOfTail);
        }
        return sets;
    }

    public Set<Integer> getPowerSet(List<Integer> list) {
        return null;
    }

    public Integer[] range(int start, int end) {
        Integer[] result = new Integer[end - start];
        for(int i=start; i<end; i++) {
            result[i] = i;
        }
        return result;
    }

    public int sum(List<Integer> arr) {
        int sum = 0;
        for(int val : arr) {
            sum += val;
        }
        return sum;
    }

    public List<Pair<List<Integer>, List<Integer>>> getAllSolutionPairs() {
        // a sort prior to iterating would help optimize this
        List<Pair<List<Integer>, List<Integer>>> solutionPairs = new ArrayList<>();
        Set<List<Integer>> setOfAllIndices = getAllPermutations(this.arr);
        List<List<Integer>> listOfAllSubLists = new ArrayList<>(setOfAllIndices.size());
        for(int i=0; i<listOfAllSubLists.size(); i++) {
            List<Integer> leftSubArray = listOfAllSubLists.get(i);
            for(int j = i+1; j<leftSubArray.size(); j++) {
                List<Integer> rightSubArray = listOfAllSubLists.get(j);
                int leftSubArraySum = sum(leftSubArray);
                int rightSubArraySum = sum(rightSubArray);
                if(leftSubArraySum > rightSubArraySum) {
                    solutionPairs.add(new Pair<>(leftSubArray, rightSubArray));
                }
            }
        }
        return solutionPairs;
    }

    public Integer solve() {
        return getAllSolutionPairs().size();
    }

    /*
     * Complete the 'splitIntoTwo' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int splitIntoTwo(List<Integer> arr) {
        return new Result1(arr).solve();
    }

}
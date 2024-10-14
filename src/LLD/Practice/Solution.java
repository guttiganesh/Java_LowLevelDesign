package LLD.Practice;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Create a frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

       return Arrays.stream(nums).boxed().sorted((a,b) ->
               freq.get(a) != freq.get(b) ? freq.get(a) - freq.get(b) : b - a).mapToInt(n -> n).toArray();

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,1,2,2,2,3};
        int[] sortedNums = sol.frequencySort(nums);
        System.out.println(Arrays.toString(sortedNums));
    }
}

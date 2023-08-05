package slidingwindow.problems;

import utils.Reader;
import utils.Helper;
import java.util.HashSet;
import java.io.IOException;

// Problem Link: https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/
class CountCompleteSubarrays {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int[] nums = Helper.getIntArray(n, reader);

        CountCompleteSubarrays obj = new CountCompleteSubarrays();
        System.out.println(obj.countCompleteSubarrays(nums));
    }

    // O(N) approach through Sliding Window.
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> distinctElements = new HashSet<>();

        for (int i=0; i<n; i++) {
            if (!distinctElements.contains(nums[i])) {
                distinctElements.add(nums[i]);
            }
        }

        int totalDistinct = distinctElements.size();
        int i = 0;
        int j = 0;
        int[] count = new int[2001];
        count[nums[i]]++;
        int curDistinct = 1;
        int subArrays = 0;

        while (true) {
            if (curDistinct < totalDistinct) {
                j++;    
                if (j >= n) {
                    break;
                }
                if (count[nums[j]] == 0) {
                    curDistinct++;
                }
                count[nums[j]]++;
            } else {
                subArrays += (n-j);
                if (i >= n) {
                    break;
                }
                count[nums[i]]--;
                if (count[nums[i]] == 0) {
                    curDistinct--;
                }
                i++;
            }
        }

        return subArrays;
    }

    // O(N^2) approach through Hashtables.
    public int countCompleteSubarraysNaive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> distinctElements = new HashSet<>();

        for (int i=0; i<n; i++) {
            if (!distinctElements.contains(nums[i])) {
                distinctElements.add(nums[i]);
            }
        }

        int subArrays = 0;
        for (int i=0; i<n; i++) {
            HashSet<Integer> curDistinct = new HashSet<>();
            for (int j=i; j<n; j++) {
                if (!curDistinct.contains(nums[j])) {
                    curDistinct.add(nums[j]);
                }
                if (curDistinct.size() == distinctElements.size()) {
                    subArrays += (n-j);
                    break;
                }
            }
        }

        return subArrays;
    }
}
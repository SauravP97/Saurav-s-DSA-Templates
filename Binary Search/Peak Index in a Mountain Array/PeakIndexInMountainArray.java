package binarysearch.problems;

import utils.Reader;
import utils.Helper;
import java.io.IOException;

// Problem link: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
class PeakIndexInMountainArray {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();

        int[] arr = Helper.getIntArray(n, reader);

        PeakIndexInMountainArray obj = new PeakIndexInMountainArray();
        System.out.println(obj.peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        return findPeakIndex(arr, 0, arr.length-1);
    }

    public int findPeakIndex(int[] arr, int start, int end) {
        if (start <= end) {
            int mid = (start + end)/2;
            if (((mid-1) >= 0) && (arr[mid-1] < arr[mid]) && ((mid+1) < arr.length) && (arr[mid+1] < arr[mid])) {
                return mid;
            }
            if (((mid+1) < arr.length) && (arr[mid] < arr[mid+1])) {
                return findPeakIndex(arr, mid+1, end);
            }
            if (((mid+1) < arr.length) && (arr[mid] > arr[mid+1])) {
                return findPeakIndex(arr, start, mid-1);
            }
        }
        return -1;
    }
}
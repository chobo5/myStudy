package herb;

import java.util.Arrays;
import java.util.Random;

public class _시간복잡도 {
    //O(1)
    public void printFirstElement(int[] arr) {
        System.out.println(arr[0]);
    }

    //O(n)
    //선형 탐색 알고리즘
    public int linearSearch(int[] arr, int target) {
        for(int x : arr) {
            if (x == target) {
                return x;
            }
        }
        return -1;
    }

    //O(n^2)
    //버블 정렬 알고리즘
    public void bubbleSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //O(logN)
    //이진 탐색
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (target > arr[middle]) {
                left = middle + 1;
            } else if (target < arr[middle]) {
                right = middle - 1;
            } else {
                return 1;
            }
        }
        return 0;

    }

    //O(nlogN)
    //퀵 정렬
//    public void quickSort(int[] arr, int low, int high) {
//        int pivot =
//    }
//
//    public int partition(int[] arr, int low, int high) {
//        int pivot = arr[low];
//        int left = low + 1;
//        int right = high;
//
//        while (left <= right) {
//            while (left <= right && arr[left] <= pivot) {
//                left++;
//            }
//
//            while (left <= right && arr[right] >= pivot) {
//                right--;
//            }
//
//
//        }
//    }


}

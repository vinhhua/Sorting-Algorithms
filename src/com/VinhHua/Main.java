package com.VinhHua;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] array = {2, -15, 23, -4, 3, 5, 7, 16};
	    int[] array2 = {3, -2, 4, 6, 12, 25, 5, -12};
 	    bubbleSort(array);
 	    insertionSort(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println(binarySearch(array, 3));

    }

    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > key) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }
    }

    private static int binarySearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        } else {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

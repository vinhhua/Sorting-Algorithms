package com.VinhHua;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    int[] array = {2, -15, 23, -4, 3, 5, 7, 16};
	    int[] array2 = {3, -2, 4, 6, 12, 25, 5, -12};
 	    bubbleSort(array);
 	    insertionSortDes(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println(binarySearch(array, 3));

        Random rand = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println();

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

    private static void insertionSortDes(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i;
            while (j > 0 && array[j - 1] < key) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int largest = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[largest]) {
                    largest = j;
                }
            }
            swap(arr, largest, i);
        }
    }

    // Binary search
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


    public static void shellSort(int[] array) {
        // As long as gap is > 0, continue this loop
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];

                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);

    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;

        while (i < j) {
            // NOTE: empty loop body
            while (i < j && array[--j] >= pivot);
            if (i < j) {
                array[i] = array[j];
            }
            // NOTE: empty loop body
            while (i < j && array[++i] <= pivot);
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[j] = pivot;
        return j;
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

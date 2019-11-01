package com.VinhHua;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] array = {2, -15, 23, -4, 3, 5, 7, 16};
	    bubbleSort(array);
        System.out.println(Arrays.toString(array));

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

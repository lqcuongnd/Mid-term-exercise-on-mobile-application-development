package com.example.giuakynhom4.SortAlgorithms;

import java.util.Arrays;

public class BinaryInsertionSort implements SortInterface {

    public BinaryInsertionSort() {
    }

    public void sort(int[] a){
        for (int i = 1; i < a.length; i++)
        {
            int x = a[i];

            // Find location to insert using binary search
            int j = Math.abs(Arrays.binarySearch(a, 0, i, x) + 1);

            //Shifting array to one location right
            System.arraycopy(a, j, a, j+1, i-j);

            //Placing element at its correct location
            a[j] = x;
        }
    }

}

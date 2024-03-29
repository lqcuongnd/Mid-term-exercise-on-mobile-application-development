package com.example.giuakynhom4.SortAlgorithms;

public class CountingSort implements SortInterface {

    public CountingSort() {
    }

    private void countingSort(int[] collection, int maxValue) {
        int[] countArray = countOccurrences(collection, maxValue);
        reconstructArray(collection, countArray, maxValue);
    }

    private int findMaxValue(int[] collection) {
        int highest = collection[0];
        for (int index = 1; index < collection.length; index ++) {
            if (collection[index] > highest) {
                highest = collection [index];
            }
        }
        return highest;
    }

    private int[] countOccurrences(int[] collection, int maxValue) {
        int[] tempArray = new int[maxValue + 1];
        for (int i = 0; i < collection.length; i++) {
            int key = collection[i];
            tempArray[key]++;
        }
        return tempArray;
    }

    private void reconstructArray(int[] collection, int[] countArray, int maxValue) {
        int j = 0;
        for (int i = 0; i <= maxValue; i++) {
            while (countArray[i] > 0) {
                collection[j++] = i;
                countArray[i]--;
            }
        }
    }

    public void sort(int[] a){
        if (a != null) {
            int maxValue = findMaxValue(a);
            countingSort(a, maxValue);
        } else {
            throw new IllegalArgumentException("Input paramenter for array to sort is null.");
        }
    }
}

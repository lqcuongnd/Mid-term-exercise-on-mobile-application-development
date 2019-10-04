package com.example.giuakynhom4;

import java.util.Arrays;

public class PigeonholeSort implements SortInterface {

    public PigeonholeSort() {
    }

    public void sort(int[] a) {
        int n = a.length;
        int min = a[0];
        int max = a[0];
        int range, i, j, index;

        for (int ii = 0; ii < n; ii++) {
            if (a[ii] > max)
                max = a[ii];
            if (a[ii] < min)
                min = a[ii];
        }

        range = max - min + 1;
        int[] p = new int[range];
        Arrays.fill(p, 0);

        for (i = 0; i < n; i++)
            p[a[i] - min]++;

        index = 0;

        for (j = 0; j < range; j++)
            while (p[j]-- > 0)
                a[index++] = j + min;

    }
}

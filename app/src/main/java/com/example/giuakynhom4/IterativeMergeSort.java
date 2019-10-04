package com.example.giuakynhom4;

public class IterativeMergeSort implements SortInterface {

    public IterativeMergeSort() {
    }

    public void sort(int[] a)
    {
        if(a == null)
        {
            return;
        }

        if(a.length > 1)
        {
            int mid = a.length / 2;

            // Split left part
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++)
            {
                left[i] = a[i];
            }

            // Split right part
            int[] right = new int[a.length - mid];
            for(int i = mid; i < a.length; i++)
            {
                right[i - mid] = a[i];
            }
            sort(left);
            sort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while(i < left.length && j < right.length)
            {
                if(left[i] < right[j])
                {
                    a[k] = left[i];
                    i++;
                }
                else
                {
                    a[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while(i < left.length)
            {
                a[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length)
            {
                a[k] = right[j];
                j++;
                k++;
            }
        }
    }

}

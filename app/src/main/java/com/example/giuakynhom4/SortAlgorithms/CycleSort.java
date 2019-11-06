package com.example.giuakynhom4.SortAlgorithms;

public class CycleSort implements SortInterface {

    public CycleSort() {
    }

    public void sort(int a[])
    {
        int n = a.length;
        // count number of memory writes
        int writes = 0;

        // traverse array elements and put it to on
        // the right place
        for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
            // initialize item as starting point
            int item = a[cycle_start];

            // Find position where we put the item. We basically
            // count all smaller elements on right side of item.
            int pos = cycle_start;
            for (int i = cycle_start + 1; i < n; i++)
                if (a[i] < item)
                    pos++;

            // If item is already in correct position
            if (pos == cycle_start)
                continue;

            // ignore all duplicate elements
            while (item == a[pos])
                pos += 1;

            // put the item to it's right position
            if (pos != cycle_start) {
                int temp = item;
                item = a[pos];
                a[pos] = temp;
                writes++;
            }

            // Rotate rest of the cycle
            while (pos != cycle_start) {
                pos = cycle_start;

                // Find position where we put the element
                for (int i = cycle_start + 1; i < n; i++)
                    if (a[i] < item)
                        pos += 1;

                // ignore all duplicate elements
                while (item == a[pos])
                    pos += 1;

                // put the item to it's right position
                if (item != a[pos]) {
                    int temp = item;
                    item = a[pos];
                    a[pos] = temp;
                    writes++;
                }
            }
        }
    }
}

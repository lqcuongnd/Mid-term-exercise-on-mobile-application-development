package com.example.giuakynhom4;

public class Sort {

    private SortInterface[] sortting;

    public Sort() {
        sortting = new SortInterface[16];
        sortting[0] = new BubbleSort();
        sortting[1] = new SelectionSort();
        sortting[2] = new RecursiveBubbleSort();
        sortting[3] = new InsertionSort();
        sortting[4] = new RecursiveInsertionSort();
        sortting[5] = new MergeSort();
        sortting[6] = new IterativeMergeSort();
        sortting[7] = new QuickSort();
        sortting[8] = new HeapSort();
        sortting[9] = new CountingSort();
        sortting[10] = new RadixSort();
        sortting[11] = new ShellSort();
        sortting[12] = new PigeonholeSort();
        sortting[13] = new CycleSort();
        sortting[14] = new CocktailSort();
        sortting[15] = new BinaryInsertionSort();
    }

    public void doSortting(int sortTypeCode, int[] num) {
        sortting[sortTypeCode].sort(num);
    }

    public String getTypeSorttingName(int sortTypeCode) {
        String s = sortting[sortTypeCode].getClass().toString();
        String[] name = s.split("\\.",-1);
        int l = name.length;

        s = name[l - 1];
        return s;
    }
}

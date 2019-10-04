package com.example.giuakynhom4;

public class HeapSort implements SortInterface {

    public HeapSort() {
    }

    public void sort(int a[]){
        buildheap(a);
        for (int i = a.length - 1; i >= 0; i--) {
            exchange(a, i, 0);
            heap(a, i, 0);
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void heap(int[] nums, int size, int i) {
        int left = ((2 * i) + 1);
        int right = ((2 * i) + 2);
        int max = i;

        if ((left < size) && (nums[left] > nums[i])) {
            max = left;
        }

        if ((right < size) && (nums[right] > nums[max])) {
            max = right;
        }

        if (max != i) {
            exchange(nums, i, max);
            heap(nums, size, max);
        }
    }

    private void buildheap(int[] nums) {
        for (int i = (nums.length / 2) - 1; i >= 0; i--) {
            heap(nums, (nums.length - 1), i);
        }
    }

}

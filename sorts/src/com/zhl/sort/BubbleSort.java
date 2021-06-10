package com.zhl.sort;

import java.util.Arrays;

public class BubbleSort {
    void sort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j <a.length-i-1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    public static void main(String[] args) {
        BubbleSort shellSort=new BubbleSort();
        int [] a={1,3,2,5,4,8,6};
        shellSort.sort(a);
        Arrays.stream(a).asLongStream().forEach(System.out::println);
    }
}

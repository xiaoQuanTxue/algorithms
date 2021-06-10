package com.zhl.sort;

import java.util.Arrays;

public class MergeSort {

    private static int[] aux;

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = i; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sort(int[] a){
        aux=new int[a.length];
        sort(a,0,a.length-1);
    }
    private static boolean less(int a, int b) {
        return a < b;
    }

    public static void main(String[] args) {
        int [] a={1,3,2,5,4,8,6};
        sort(a);
        Arrays.stream(a).asLongStream().forEach(System.out::println);
    }
}

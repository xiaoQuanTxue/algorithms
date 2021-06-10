package com.zhl.sort;

import java.util.Arrays;

public class InsertionSort {
    void sort(int [] a){
        for(int i=1;i<a.length;i++){
            int tmp=a[i];
            int j=i;
            for(;j>0&&a[j-1]>tmp;j--){
                a[j]=a[j-1];
            }
            a[j]=tmp;
        }
    }

    void exch(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    public static void main(String[] args) {
        InsertionSort insertSort = new InsertionSort();
        int [] a={1,3,2,5,4,8,6};
        insertSort.sort(a);
        Arrays.stream(a).asLongStream().forEach(System.out::println);
    }
}

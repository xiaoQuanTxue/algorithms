package com.zhl.sort;

import java.util.Arrays;

public class SimpleSelectionSort {

    void sort(int [] a){
        for(int i=0;i<a.length-1;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min])min=j;
            }
            exch(a,min,i);
        }
    }
    void exch(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    public static void main(String[] args) {
        SimpleSelectionSort simpleSort = new SimpleSelectionSort();
        int [] a={1,3,2,5,4,8,6};
        simpleSort.sort(a);
        Arrays.stream(a).asLongStream().forEach(System.out::println);
    }
}

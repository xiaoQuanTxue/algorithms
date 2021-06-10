package com.zhl.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    void sort(int[] a){

        int[] nums={5,2,1};
        int d=0;

        for(;d<nums.length;d++){

            for (int i = nums[d]; i<a.length;i++) {
                int tmp=a[i];
                int j = i;
                for (; j >=i&&tmp<a[j-nums[d]]; j-=nums[d]) {
                    a[j]=a[j-nums[d]];
                }
                a[j]=tmp;
            }
        }
    }
    void sort2(int[] a){

        int[] nums={5,2,1};

        int i,j,d;

        for(d=0;d<nums.length;d++){
            int s=nums[d];

            for(i=nums[d];i<a.length;i++){
                int tmp=a[i];
                for(j=i;j>=i&&tmp<a[j-s];j-=s){
                    a[j]=a[j-s];
                }
                a[j]=tmp;
            }
        }

    }
    public static void main(String[] args) {
        ShellSort shellSort=new ShellSort();
        int [] a={1,3,2,5,4,8,6};
        shellSort.sort2(a);
        Arrays.stream(a).asLongStream().forEach(System.out::println);
    }
}

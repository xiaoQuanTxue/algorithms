package com.zhl.search;

public class BinerySearch {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7};
        System.out.println(binerySearch(a,0));
    }

    static int binerySearch(int[] a, int i) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (i > a[mid]) lo = mid + 1;
            else if (i < a[mid]) hi = mid - 1;
            else return mid;
        }
        throw new RuntimeException("未找到次数");
    }
}

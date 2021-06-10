package com.zhl.sparseArray;

import java.io.*;
import java.nio.file.Path;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        int [][] chess=new int[11][11];
        int sum=0;
        chess[2][3]=1;
        chess[4][5]=2;
        //遍历二维数组
        for (int[] c:chess) {
            for (int i:c){
                if(i!=0){
                    sum++;
                }
                System.out.printf("%d \t",i);
            }
            System.out.println();
        }
        //创建稀疏矩阵
        int [][] sparseArray=new int[sum+1][3];
        sparseArray[0][0]=chess[0].length;
        sparseArray[0][1]=chess.length;
        sparseArray[0][2]=sum;
        //遍历二位数组，将数据存储到稀疏矩阵
        int count=0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chess[i][j];
                }
            }
        }
        //遍历稀疏矩阵
        System.out.println("================sparse==================");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        //将sparseArray恢复成二维数组
        int [][] chess2=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
            chess2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        //遍历恢复后二维数组
        for (int[] c:chess2) {
            for (int i:c){
                if(i!=0){
                    sum++;
                }
                System.out.printf("%d \t",i);
            }
            System.out.println();
        }

        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("SparseArray/map.data"));
        outputStream.writeObject(sparseArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("SparseArray/map.data"));
        try {
            int[][] sparseArray1 =(int[][]) objectInputStream.readObject();
            //遍历稀疏矩阵
            System.out.println("================sparse1==================");
            for (int i = 0; i < sparseArray1.length; i++) {
                System.out.printf("%d\t%d\t%d\t\n",sparseArray1[i][0],sparseArray1[i][1],sparseArray1[i][2]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

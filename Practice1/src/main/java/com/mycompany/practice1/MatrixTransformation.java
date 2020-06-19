package com.mycompany.practice1;

// 矩陣轉換

import java.util.Scanner;

public class MatrixTransformation {
    static int[][] oldMatrix = new int[10][10];
    static int[][] newMatrix = new int[10][10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();
        int row = sc.nextInt();
        int steps = sc.nextInt();
        
        for (int i = 0;i < column;i++) {
            for (int j = 0;j < row;j++) {
               oldMatrix[i][j] = sc.nextInt();
            }
        }
        /*
            旋轉
            00 01   20 10 00
            10 11   21 11 01
            20 21
            
            翻轉
            00 01   20 21
            10 11   10 11
            20 21   00 01
        */
        
        // 0 -> 旋轉(90), 1 -> 翻轉(上下顛倒)
        for (int i = 0;i < steps;i++) {
            int action = sc.nextInt();
            if (action == 0) {
                int temp = row;
                row = column;
                column = temp;
                // 旋轉
                for (int c = 0;c < column;c++) {
                    for (int r = 0;r < row;r++) {
                        newMatrix[c][r]= oldMatrix[row-1-r][c];
                    }
                }
            } else {
                // 翻轉
                for (int c = 0;c < column;c++) {
                    for (int r = 0;r < row;r++) {
                        newMatrix[c][r] = oldMatrix[column-1-c][r];
                    }
                }
            }
            oldMatrix = new int[10][10];
            oldMatrix = newMatrix;
            newMatrix = new int[10][10];
        }
        
        System.out.print(column + " ");
        System.out.println(row);
        
        for (int c = 0;c < column;c++) {
            for (int r = 0;r < row;r++) {
                System.out.print(oldMatrix[c][r] + " ");
            }
            System.out.println("");
        }
        
    }
}

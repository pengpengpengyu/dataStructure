package com.example.datastructure;

import org.junit.jupiter.api.Test;

/**
 * 稀疏数组
 */
public class SparseArrayTest {

    @Test
    public void test() {
        /**
         * 稀疏数组只存放非0数据:
         * 共三列:
         * 第一行第一列存放 原二维数组一共有几行几列几个非0值
         * 其他所有行存放格式为原二维数组 行 列 值
         *
         *
         * 11	11	3
         * 1	3	1
         * 2	2	1
         * 4	5	2
         * 上面demo表示 :
         * 原二维数组共11行11列3个非0值
         * 第二行第四列值为1
         * 第三行第三列值为1
         * 第五行第六列值为2
         * ...
         */


        // 初始化二维数组(11*11的棋盘), 0表示无棋子,1表示白,2表示黑
        int[][] chessBord = new int[11][11];
        chessBord[1][3] = 1;
        chessBord[4][5] = 2;
        chessBord[2][2] = 1;
        System.out.println("原始二维数组遍历:");
        for (int[] chessArray : chessBord) {
            for (int item : chessArray) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        int sum = 0;
        for (int[] chessArray : chessBord) {
            for (int item : chessArray) {
                if (0 != item) {
                    sum += 1;
                }
            }
        }
        System.out.printf("\n二维数组元素总数: %d", sum);

        // 创建对应稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 二维数组转为稀疏数组
        int count = 0;
        for (int i = 0; i < chessBord.length; i++) {
            for (int j = 0; j < chessBord[i].length; j++) {
                if (chessBord[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessBord[i][j];
                }
            }
        }

        System.out.println("\n稀疏数组遍历");
        for (int[] spe : sparseArray) {
            for (int item : spe) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        // 稀疏数组转为二维数组
        int[][] cheesBord2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            cheesBord2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("\n遍历稀疏数组转换后的二位数组");
        for (int[] array : cheesBord2) {
            for (int item : array) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}

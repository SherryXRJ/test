package pers.sherry.algorithm.sort.selecttion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 选择排序
 * 时间复杂度O(n) = n^2
 */
public class Selection {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int SIZE = 10;
        int[] arr = new int [SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = scan.nextInt();
        }
        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;        //  最小索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;    //  刷新最小索引
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }
}

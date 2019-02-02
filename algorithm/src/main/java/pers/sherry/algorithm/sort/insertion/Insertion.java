package pers.sherry.algorithm.sort.insertion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 插入排序
 * 时间复杂度O(n) = n^2
 */
public class Insertion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int SIZE = 10;
        int[] arr = new int [SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = scan.nextInt();
        }

        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                System.out.println(Arrays.toString(arr));
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

}

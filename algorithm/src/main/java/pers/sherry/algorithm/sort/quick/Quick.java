package pers.sherry.algorithm.sort.quick;

public class Quick {

    public static void main(String[] args) {
        int arr[] = {2, 5, 4, 1, 3, 7, 9, 6, 0, 8};

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void quickSort(int[] arr, int s, int e){
        if (s > e) {
            return;
        }

        int pivot = arr[s]; //  基准点
        int i = s, j = e;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }

            while (i < j && arr[i] <= pivot) {
                i++;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[s] = arr[j];
        arr[j] = pivot;

        quickSort(arr, s, j - 1);
        quickSort(arr, j + 1, e);
    }
}

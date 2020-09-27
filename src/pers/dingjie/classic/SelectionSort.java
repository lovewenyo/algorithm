package pers.dingjie.classic;

/**
 * @author : dingjie
 * @description : 选择排序
 * @date : 2017年9月11日 下午2:27:14
 */
public class SelectionSort {

    /**
     * @description 传统简单选择排序
     */
    public void selectionSort_1(int[] arr) {
        int n = arr.length;
        int minIndex = 0;
        int temp = 0;

        for (int i = 0; i < n - 1; ++i) {
            minIndex = i;

            for (int j = i + 1; j < n; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * @description 改进后的简单选择排序
     * 每次找到最小的数和最大的数
     */
    public void selectionSort_2(int[] arr) {
        int n = arr.length;
        int minIndex, maxIndex;
        int temp = 0;

        for (int i = 0; i < n / 2; ++i) {
            minIndex = i;
            maxIndex = n - i - 1;
            for (int j = i + 1; j < n - i; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            if (maxIndex != n - i - 1) {
                temp = arr[n - i - 1];
                arr[n - i - 1] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

}

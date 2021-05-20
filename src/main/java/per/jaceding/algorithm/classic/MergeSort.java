package per.jaceding.algorithm.classic;

/**
 * 归并排序
 *
 * @author jaceding
 * @date 2017年9月11日 下午7:47:31
 */
public class MergeSort {

    /**
     * 手摇法
     *
     * @param arr
     * @param bias
     * @param oneSize
     * @param anotherSize
     */
    private static void swapAdjacentBlocks(int arr[], int bias, int oneSize, int anotherSize) {
        reverse(arr, bias, bias + oneSize - 1);
        reverse(arr, bias + oneSize, bias + oneSize + anotherSize - 1);
        reverse(arr, bias, bias + oneSize + anotherSize - 1);
    }

    /**
     * 翻转数组
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    /**
     * @description 传统归并排序 参数简化
     */
    public void sort(int arr[]) {
        merge_sort_1(arr, 0, arr.length - 1, new int[arr.length]);
    }

    /**
     * @description 原地归并排序 参数简化
     */
    public void mergeSort_2(int arr[]) {
        merge_sort_2(arr, 0, arr.length - 1);
    }

    /**
     * @description 传统归并排序
     */
    public void merge_sort_1(int arr[], int first, int last, int temp[]) {
        if (first < last) {
            int middle = (first + last) >> 1;
            merge_sort_1(arr, first, middle, temp);//左半部分排好序
            merge_sort_1(arr, middle + 1, last, temp);//右半部分排好序
            mergeArray(arr, first, middle, last, temp); //合并左右部分
        }
    }

    /**
     * @description 原地归并排序
     */
    public void merge_sort_2(int arr[], int first, int last) {
        if (first < last) {
            int middle = (first + last) >> 1;
            merge_sort_2(arr, first, middle);//左半部分排好序
            merge_sort_2(arr, middle + 1, last);//右半部分排好序
            inplaceMerge(arr, first, middle, last); //合并左右部分
        }
    }

    /**
     * @description 原地归并
     */
    public void inplaceMerge(int arr[], int first, int middle, int end) {
        int i = first;
        int j = middle + 1;

        while (i < j && j <= end) {
            while (i < j && arr[i] <= arr[j]) {
                i++;
            }
            int index = j;
            while (j <= end && arr[j] <= arr[i]) {
                j++;
            }
            swapAdjacentBlocks(arr, i, index - i, j - index);
            i += (j - index);
        }
    }

    /**
     * @description 传统归并
     * 将两个序列a[first-middle],a[middle+1-end]合并
     */
    public void mergeArray(int arr[], int first, int middle, int end, int temp[]) {
        int i = first;
        int m = middle;
        int j = middle + 1;
        int n = end;
        int k = 0;

        while (i <= m && j <= n) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i <= m) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= n) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for (int ii = 0; ii < k; ii++) {
            arr[first + ii] = temp[ii];
        }
    }
}

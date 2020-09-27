package pers.dingjie.classic;

import java.util.Stack;

/**
 * @author : dingjie
 * @description : 快速排序
 * @date : 2017年7月24日 上午10:22:53
 */
public class QuickSort {

    /**
     * @description 递归实现快速排序 (分治+挖坑法分区)
     */
    public void quickSort_1(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 < 13) {
                new InsertionSort().insertionSort_1(arr);
                return;
            }
            int i = partition_1(arr, low, high);
            quickSort_1(arr, low, i - 1);
            quickSort_1(arr, i + 1, high);
        }
    }

    /**
     * @description 递归实现快速排序 (分治+左右指针法分区)
     */
    public void quickSort_2(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 < 13) {
                new InsertionSort().insertionSort_1(arr);
                return;
            }
            int i = partition_2(arr, low, high);
            quickSort_2(arr, low, i - 1);
            quickSort_2(arr, i + 1, high);
        }
    }

    /**
     * @description 递归实现快速排序 (分治+前后指针法分区)
     */
    public void quickSort_3(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 < 13) {
                new InsertionSort().insertionSort_1(arr);
                return;
            }
            int i = partition_3(arr, low, high);
            quickSort_3(arr, low, i - 1);
            quickSort_3(arr, i + 1, high);
        }
    }

    /**
     * @description 非递归实现快速排序 (分治+挖坑法分区)
     */
    public void quickSort_4(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(low);
        stack.push(high);//后入的high，所以要先拿high

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            if (high - low + 1 < 13) {
                new InsertionSort().insertionSort_1(arr);
                continue;
            }
            int i = partition_1(arr, low, high);

            if (i - 1 > low) {
                stack.push(low);
                stack.push(i - 1);
            }
            if (i + 1 < high) {
                stack.push(i + 1);
                stack.push(high);
            }
        }
    }

    /**
     * @description 递归实现三路快速排序
     * 适用于重复元素比较多的情况
     */
    public void quickSort_5(int[] arr, int low, int high) {
        if (high <= low)
            return;
        if (high - low + 1 < 13) {
            new InsertionSort().insertionSort_1(arr);
            return;
        }
        int p, q, i, j, temp;
        int pivot;
        i = p = low;
        j = q = high - 1;
        pivot = arr[high];

        while (true) {
            while (i < high && arr[i] <= pivot) {
                if (arr[i] == pivot) {
                    temp = arr[i];
                    arr[i] = arr[p];
                    arr[p] = temp;
                    p++;
                }
                i++;
            }
            while (low <= j && arr[j] >= pivot) {
                if (arr[j] == pivot) {
                    temp = arr[j];
                    arr[j] = arr[q];
                    arr[q] = temp;
                    q--;
                }
                j--;
            }
            if (i >= j)
                break;

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        i--;
        p--;
        while (p >= low) {
            temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
            i--;
            p--;
        }
        j++;
        q++;
        while (q <= high) {
            temp = arr[j];
            arr[j] = arr[q];
            arr[q] = temp;
            j++;
            q++;
        }
        quickSort_5(arr, low, i);
        quickSort_5(arr, j, high);
    }

    /**
     * @description 分区操作(挖坑法)
     * 严版教材的划分算法
     */
    public int partition_1(int[] arr, int low, int high) {
        int mid = getMid(arr, low, high);//三数取中法
        int temp = arr[mid];
        arr[mid] = arr[low];
        arr[low] = temp;

        int pivot = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    /**
     * @description 分区操作(左右指针法)
     */
    public int partition_2(int[] arr, int low, int high) {
        int mid = getMid(arr, low, high);//三数取中法
        int temp = arr[mid];
        arr[mid] = arr[low];
        arr[low] = temp;

        int pivot = arr[low];
        int flag = low;//因为low后面改变了，所以用flag记录一下枢轴

        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            while (low < high && arr[low] <= pivot) ++low;
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
        temp = arr[low];
        arr[low] = arr[flag];
        arr[flag] = temp;
        return low;
    }

    /**
     * @description 分区操作(前后指针法)
     */
    public int partition_3(int[] arr, int low, int high) {
        int mid = getMid(arr, low, high);//三数取中法
        int temp = arr[mid];
        arr[mid] = arr[low];
        arr[low] = temp;

        int pivot = arr[low];
        int pre = high + 1, cur = pre - 1;

        while (cur > low) {
            if (arr[cur] >= pivot && --pre != cur) {
                temp = arr[cur];
                arr[cur] = arr[pre];
                arr[pre] = temp;
            }
            --cur;
        }
        temp = arr[--pre];
        arr[pre] = arr[low];
        arr[low] = temp;
        return pre;
    }

    /**
     * @description 三数取中法
     * 如果枢轴为这段序列的最大值或最小值时，快排的效率会极速退化。
     * 每次在选枢轴时，在序列的第一，中间，最后三个值里面选一个中间值出来作为枢轴，保证每次划分接近均等。
     */
    public int getMid(int[] arr, int low, int high) {
        int mid = low + ((high - low) >> 1);

        if (arr[low] <= arr[high]) {
            if (arr[mid] < arr[low])
                return low;
            else if (arr[mid] > arr[high])
                return high;
            else
                return mid;
        } else {
            if (arr[mid] < arr[high])
                return high;
            else if (arr[mid] > arr[low])
                return low;
            else
                return mid;
        }
    }

}

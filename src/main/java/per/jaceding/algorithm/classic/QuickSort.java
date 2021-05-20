package per.jaceding.algorithm.classic;

import java.util.Stack;

/**
 * 快速排序
 *
 * @author jaceding
 * @date 2017年7月24日 上午10:22:53
 */
public class QuickSort {

    /**
     * 递归实现快速排序 (分治+挖坑法分区)
     *
     * @param arr  数组
     * @param low  待排数组最小索引
     * @param high 待排数组最大索引
     */
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int i = partition(arr, low, high);
            sort(arr, low, i - 1);
            sort(arr, i + 1, high);
        }
    }

    /**
     * 递归实现快速排序 (分治+左右指针法分区)
     *
     * @param arr  数组
     * @param low  待排数组最小索引
     * @param high 待排数组最大索引
     */
    public static void sort2(int[] arr, int low, int high) {
        if (low < high) {
            int i = partition2(arr, low, high);
            sort2(arr, low, i - 1);
            sort2(arr, i + 1, high);
        }
    }

    /**
     * 递归实现快速排序 (分治+前后指针法分区)
     *
     * @param arr  数组
     * @param low  待排数组最小索引
     * @param high 待排数组最大索引
     */
    public static void sort3(int[] arr, int low, int high) {
        if (low < high) {
            int i = partition3(arr, low, high);
            sort3(arr, low, i - 1);
            sort3(arr, i + 1, high);
        }
    }

    /**
     * 非递归实现快速排序 (分治+挖坑法分区)
     *
     * @param arr  数组
     * @param low  待排数组最小索引
     * @param high 待排数组最大索引
     */
    public static void sort4(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        //后入的high，所以要先拿high
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            if (high - low + 1 < 13) {
                InsertionSort.sort(arr);
                continue;
            }
            int i = partition(arr, low, high);

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
     * 递归实现三路快速排序
     * 适用于重复元素比较多的情况
     *
     * @param arr  数组
     * @param low  待排数组最小索引
     * @param high 待排数组最大索引
     */
    public static void sort5(int[] arr, int low, int high) {
        if (high <= low) {
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
            if (i >= j) {
                break;
            }

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
        sort5(arr, low, i);
        sort5(arr, j, high);
    }

    /**
     * 分区操作(挖坑法) 严版教材的划分算法
     *
     * @param arr  数组
     * @param low  待排数组最小索引
     * @param high 待排数组最大索引
     * @return 索引值
     */
    public static int partition(int[] arr, int low, int high) {
        //三数取中法
        int mid = getMid(arr, low, high);
        int temp = arr[mid];
        arr[mid] = arr[low];
        arr[low] = temp;

        int pivot = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    /**
     * 分区操作(左右指针法)
     *
     * @param arr  数组
     * @param low  待排数组最小索引
     * @param high 待排数组最大索引
     * @return 索引值
     */
    public static int partition2(int[] arr, int low, int high) {
        //三数取中法
        int mid = getMid(arr, low, high);
        int temp = arr[mid];
        arr[mid] = arr[low];
        arr[low] = temp;

        int pivot = arr[low];
        //因为low后面改变了，所以用flag记录一下枢轴
        int flag = low;

        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
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
     * 分区操作(前后指针法)
     *
     * @param arr  数组
     * @param low  待排数组最小索引
     * @param high 待排数组最大索引
     * @return 索引值
     */
    public static int partition3(int[] arr, int low, int high) {
        //三数取中法
        int mid = getMid(arr, low, high);
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
     * 三数取中法
     * 如果枢轴为这段序列的最大值或最小值时，快排的效率会极速退化。
     * 每次在选枢轴时，在序列的第一，中间，最后三个值里面选一个中间值出来作为枢轴，保证每次划分接近均等。
     *
     * @param arr  数组
     * @param low  待排数组最小索引
     * @param high 待排数组最大索引
     * @return 中间值
     */
    private static int getMid(int[] arr, int low, int high) {
        int mid = low + ((high - low) >> 1);

        if (arr[low] <= arr[high]) {
            if (arr[mid] < arr[low]) {
                return low;
            } else if (arr[mid] > arr[high]) {
                return high;
            } else {
                return mid;
            }
        } else {
            if (arr[mid] < arr[high]) {
                return high;
            } else if (arr[mid] > arr[low]) {
                return low;
            } else {
                return mid;
            }
        }
    }
}

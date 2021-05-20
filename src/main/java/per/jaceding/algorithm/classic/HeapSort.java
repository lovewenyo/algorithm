package per.jaceding.algorithm.classic;

/**
 * 堆排序
 * 用数组表示堆：
 * 某个节点的索引为 i，它的左孩子索引 li=i*2+1,右孩子索引 ri=li+1=i*2+2
 *
 * @author jaceding
 * @date 2017年9月13日 下午4:38:17
 */
public class HeapSort {

    public static void sort(int[] arr) {
        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1;

        // 步骤一 构造初始堆。将给定无序序列构造成一个大顶堆（一般升序采用大顶堆，降序采用小顶堆)
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(arr, i, len);
        }

        // 步骤二 将堆顶元素与末尾元素进行交换，使末尾元素最大。然后继续调整堆，再将堆顶元素与末尾元素交换,得到第二大元素。如此反复进行交换、重建、交换。
        for (int i = len; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i - 1);
        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性
     *
     * @param arr   待排数组
     * @param index 索引
     * @param len   待排数组的长度（因为存在排好的元素）
     */
    private static void maxHeapify(int[] arr, int index, int len) {
        // 左子节点索引
        int li = (index << 1) + 1;
        // 右子节点索引
        int ri = li + 1;
        // 子节点值最大索引，默认左子节点
        int cMax = li;

        // 左子节点索引超出计算范围，直接返回
        if (li > len) {
            return;
        }
        // 先判断左右子节点，哪个较大
        if (ri <= len && arr[ri] > arr[li]) {
            cMax = ri;
        }
        if (arr[cMax] > arr[index]) {
            // 如果父节点被子节点调换
            swap(arr, cMax, index);
            // 则需要继续判断换下后的父节点是否符合堆的特性
            maxHeapify(arr, cMax, len);
        }
    }

    /**
     * 交换两个数组中两个变量的值
     *
     * @param arr 数组
     * @param i   第一个变量的索引
     * @param j   第二个变量的索引
     */
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}

package pers.dingjie.classic;

/**
 * @author : dingjie
 * @description : 堆排序
 * @date : 2017年9月13日 下午4:38:17
 */
public class HeapSort {

    private int[] arr;

    public HeapSort() {

    }

    /**
     * @description 传统堆排序
     */
    public void heapSort(int[] arr) {
        this.arr = arr;

        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1;

        /**
         * 步骤一 构造初始堆。将给定无序序列构造成一个大顶堆（一般升序采用大顶堆，降序采用小顶堆)
         */
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len);
        }

        /**
         * 步骤二 将堆顶元素与末尾元素进行交换，使末尾元素最大。然后继续调整堆，再将堆顶元素与末尾元素交换，
         *  	  得到第二大元素。如此反复进行交换、重建、交换。
         */
        for (int i = len; i > 0; i--) {
            swap(0, i);
            maxHeapify(0, i - 1);
        }

    }

    /**
     * @description 调整索引为 index 处的数据，使其符合堆的特性
     */
    private void maxHeapify(int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。

        if (li > len) return;       // 左子节点索引超出计算范围，直接返回。
        if (ri <= len && arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。
            cMax = ri;
        if (arr[cMax] > arr[index]) {
            swap(cMax, index);      // 如果父节点被子节点调换，
            maxHeapify(cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    private void swap(int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

}

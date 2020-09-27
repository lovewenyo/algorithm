package pers.dingjie.classic;

/**
 * 优点:
 * 1 桶排序是稳定的
 * 2 桶排序是常见排序算法中最快的一种，大多数情况下比快排和归并排序还要快
 * <p>
 * 缺点:
 * 1 非常浪费空间
 * 2 排序的数据非常限定，元素必须是0到某一确定范围的整数
 * <p>
 * 时间复杂度 O(n)  空间复杂度O(n+m)  n是待排元素 m是桶的个数
 * 合适的例子: 考试成绩的排序
 */

/**
 * @description : 桶排序
 * @author      : dingjie
 * @date        : 2016年7月24日 上午10:14:11
 */
public class BucketSort {
    public static void main(String[] args) {
        new BucketSort().run();
    }

    public void run() {
        int[] x = {99, 65, 24, 47, 50, 88, 33, 66, 67, 31, 18};
        int[] sorted = bucketSort(x, 99);
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] > 0)
                System.out.print(" " + sorted[i]);
        }
    }

    public int[] bucketSort(int[] nums, int maxNum) {
        /**
         * @Description: 桶排序
         * @param nums  数组
        * @param max   数组中最大的数
         * @return void
         */
        int[] sorted = new int[maxNum + 1];

        for (int i = 0; i < nums.length; i++) {
            sorted[nums[i]] = nums[i];          //把数据放到对应索引的位置
        }
        return sorted;
    }

}

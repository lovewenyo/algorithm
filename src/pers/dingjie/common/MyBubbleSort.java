package pers.dingjie.sort;

/**
 * @description :
 * @author      : dingjie
 * @date 	    : 2018年7月24日 上午10:22:45 
 */
public class MyBubbleSort {
    public  static  void sort(int[] nums) {
        int length = nums.length;
        int temp;
        for (int i =0;i<length-1;++i){
            for(int j = 0;j<length-i-1;++j){
                if(nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void sort1(int [] nums){
        int length = nums.length;
        int pos,temp;
        int i = length -1;
        while(i>0){
            pos = 0;
            for(int j = 0;j<length-1;++j){
                if(nums[j]>nums[j+1]){
                    pos = i;
                    temp = nums[j];
                    nums[j] =nums[j+1];
                    nums[j+1]=temp;
                }
            }
            i = pos;
        }
    }

    public static void sort2(int nums[]){
        int low = 0;
        int heigth = nums.length -1;
        int j ,temp;
        while(low<heigth){
            for(j=low;j<heigth;++j){
                if(nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j] =nums[j+1];
                    nums[j+1]=temp;
                }
            }
            --heigth;
            for(j=heigth;j>low;--j){
                if(nums[j]<nums[j-1]){
                    temp = nums[j];
                    nums[j] =nums[j-1];
                    nums[j-1]=temp;
                }
            }
            ++low;
        }
    }
}

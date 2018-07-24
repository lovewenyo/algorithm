package pers.dingjie.sort;


/**
 * @description : 测试
 * @author      : dingjie
 * @date 	    : 2017年7月24日 上午10:22:05 
 */
public class Client {
    public static void main(String[] args) {
        new Client().run();
    }

    private void run() {
        int nums[]={2,3,5,8,9,1,6,7,4};
        MyBubbleSort.sort2(nums);
        for(Integer o:nums){
            System.out.println(o.toString());
        }
        
    }
}

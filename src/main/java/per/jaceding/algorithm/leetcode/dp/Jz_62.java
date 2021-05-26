package per.jaceding.algorithm.leetcode.dp;

/**
 * 约瑟夫环
 *
 * 假设最后剩下的数字为x,每次删除第m个元素，每一轮数字x，index1表示倒数第一轮数字x所处的位置
 * 倒数第1轮，index1=0
 * 倒数第2轮，index2=(index1 + m) % 2
 * 倒数第3轮，index3=(index2 + m) % 3
 * 倒数第4轮，index4=(index3 + m) % 4
 * @author jaceding
 * @date 2021/5/26
 */
public class Jz_62 {

    public int lastRemaining(int n, int m) {
        if(n == 1){
            return 0;
        }
        int index = 0;
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }
}

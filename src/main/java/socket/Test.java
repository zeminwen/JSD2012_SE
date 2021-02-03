package socket;

import java.util.Arrays;

/**
 * 测试从数组中删除指定元素
 */
public class Test {
    public static void main(String[] args) {
        int[] allOut={20,115,16,43,19,52,406,288,95,343};
        int pw=52;
        System.out.println(Arrays.toString(allOut));
        //将pw从数组allOut中删除
        for (int i=0;i<allOut.length;i++){
            if (allOut[i]==pw){
                allOut[i]=allOut[allOut.length-1];
                allOut= Arrays.copyOf(allOut,allOut.length-1);
                break;//已知该数组没有重复元素，不用再继续判断了
            }
        }
        System.out.println(Arrays.toString(allOut));
    }
}

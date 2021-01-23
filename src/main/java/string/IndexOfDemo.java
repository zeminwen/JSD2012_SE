package string;

/**
 * int indexOf(String str)
 * 返回给定字符串在当前字符串的位置，如果当前字符串不包含给定内容则返回值为-1
 */
public class IndexOfDemo {
    public static void main(String[] args) {
        String str="thinking in java";
        int index=str.indexOf("in");//检索str中第一次出现in的位置
        System.out.println(index);
        //重载的indexOf方法可以从指定位置开始检索第一次出现指定字符串的位置
        index=str.indexOf("in",2);
        System.out.println(index);
        index=str.indexOf("in",3);
        System.out.println(index);

        //检索最后一次出现给定字符串的位置,可以用来检测邮箱名是否只输入一个@
        index=str.lastIndexOf("in");
        System.out.println(index);


    }
}

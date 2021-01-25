package string;

/**
 * String支持正则表达式的方法之三：
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为给定内容
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {
        String str="abc123def456ghi789jkl";
        //将字符串中数字部分替换成"#NUMBER#"
        str=str.replaceAll("[0-9]+","#Number#");
        System.out.println(str);
        //将满足的部分替换为空字符串可以达到"去除"的效果
        //和谐用语
        String regex="(wqnmlgb|dsb|mdzz|cnm|nmsl|nc|fk)";
        String message="fk!你个nc！你是一个dsb！";
        message=message.replaceAll(regex,"***");
        System.out.println(message);

    }
}

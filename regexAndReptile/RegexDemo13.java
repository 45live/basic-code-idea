package regexAndReptile;

public class RegexDemo13 {
    public static void main(String[] args) {
        /*需求:
            将字符串:我要学学编编编编程程程程程程替换为:我要学编程
        */
        String str = "我要学学编编编编程程程程程程";

        //需求:把重复的内容 替换为 单个的
        //不用去管具体的字符串，也不要考虑如何查找，去找满足某种规律的规则即可。
        //比如，想要去除重复的内容：
        //它的规则就可以是：相同的字符出现一次或者多次：(.)\\1+
        //学学                学
        //编编编编            编
        //程程程程程程        程
        //  (.)表示把重复内容的第一个字符看做一组
        //  \\1表示第一个字符再次出现
        //  + 至少一次
        //  $1 表示把正则表达式中第一组的内容，再拿出来用，替换一次，意思为去除重复内容
        String result = str.replaceAll("(.)\\1+", "$1");
        System.out.println(result);

    }
}

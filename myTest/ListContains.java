package myTest;

import java.util.*;

public class ListContains {
    public static void main(String[] args) {
        /*
        定义一个Map集合，键用来表示省份名称province，值表示city，但是市会有多个，添加完毕后，遍历结果如下：
        江苏省=南京市，扬州市，苏州市，无锡市，常州市
        湖北省=武汉市，孝感市，十堰市，宜昌市，鄂州市
        河北省=石家庄市，唐山市，邢台市，保定市，张家口市
         */

        //1.创建map集合
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        //2.创建单列集合存储市的信息
        ArrayList<String> city1 = new ArrayList<>();
        Collections.addAll(city1, "南京市", "扬州市", "苏州市", "无锡市", "常州市");

        ArrayList<String> city2 = new ArrayList<>();
        Collections.addAll(city2, "武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市");

        ArrayList<String> city3 = new ArrayList<>();
        Collections.addAll(city3, "石家庄市", "唐山市", "邢台市", "保定市", "张家口市");

        hm.put("江苏省", city1);
        hm.put("湖北省", city2);
        hm.put("河北省", city3);

        Set<Map.Entry<String, ArrayList<String>>> entries = hm.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            System.out.print(entry.getKey() + "=");
            ArrayList<String> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                if (i == value.size() - 1) {
                    System.out.print(value.get(i));
                    break;
                }
                System.out.print(value.get(i) + "，");
            }
            System.out.println();
        }
    }
}

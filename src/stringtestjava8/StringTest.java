package stringtestjava8;

import java.util.List;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/27 17:32
 */

public class StringTest {
    public static void main(String[] args) {
//        String str1 = new String("123");
        String str2 = "123" + new String("123456");
        String str3 = str2.intern();
//        String str4 = "123456";
//        String str4 = new String("123");
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str2 == str3);
//        System.out.println(str1 == str4);
        System.out.println(str2 == str3);
        System.out.println(str3);

    }
}


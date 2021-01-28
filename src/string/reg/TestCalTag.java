package string.reg;

import java.util.Arrays;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2021/1/19 22:55
 */

public class TestCalTag {
    public static void main(String[] args) {
        String str = "[1]+[2]*[3]-[4]/[5]";
        String[] res = str.split("[-|+|*|/]");
        System.out.println(Arrays.toString(res));

    }

}

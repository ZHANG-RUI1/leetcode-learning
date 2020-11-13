package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/12 9:39
 */

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(null);
        list.add(1);
        list.add(null);
        list.add(null);
        String str = "null";
        Integer in = Integer.parseInt(str);
        System.out.println(list.toString());

    }
}

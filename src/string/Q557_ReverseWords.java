package string;

import java.util.LinkedList;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/10 22:44
 */

public class Q557_ReverseWords {
    public String reverseWords(String s) {
        //1.存储每个分段字符串的索引
        LinkedList<Integer> list = new LinkedList<Integer>();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++){
            if (i == 0){ list.add(0); }
            else if (i == chs.length - 1){ list.add(chs.length - 1); }
            else if ( chs[i] == ' '){
                list.add(i - 1);
                list.add(i + 1);
            }
        }
        //2.反转分段字符串
        while(list.size() > 1){
            int x = list.pollFirst();
            int y = list.pollFirst();
            while(x < y){
                char temp = chs[x];
                chs[x++] = chs[y];
                chs[y--] = temp;
            }
        }
        return new String(chs);
    }
}

package string;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/10 22:16
 */

public class Q541_ReverseStr {

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2*k){
            int n = i;
            int j = n + k - 1;
            if(j >= ch.length){ j = ch.length - 1; }
            while(n < j){
                char temp = ch[n];
                ch[n++] = ch[j];
                ch[j--] = temp;
            }
        }
        return new String(ch);
    }
}

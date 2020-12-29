package string;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/10 21:39
 */

public class Q344_ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while(i < j){
            char temp = s[j];
            s[j++] = s[i];
            s[i++] = temp;
        }
    }
}

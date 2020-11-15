package string;

import java.util.LinkedList;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/15 17:38
 */

public class Q401_RemoveKdigits {
    /**
     *  题目：
     *      给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     *          注意:
     *              num 的长度小于 10002 且 ≥ k。
     *              num 不会包含任何前导零。
     * @param num 输入字符串
     * @param k 删除字符的个数
     * @return 返回需要的字符串
     */
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        LinkedList<Character> stack = new LinkedList<Character>();
        int i = 0;
        //1.String(i) > String(i-1) 删除String（i）
        while(i < num.length()){
            if(i > 0 && k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek() ){
                stack.pop();
                k--;
            }else{
                stack.push(num.charAt(i));
                i++;
            }
        }

        //2.当字符串数字为升序时
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        StringBuffer sb = new StringBuffer();
        for (Character ch: stack) {
            sb.append(ch);
        }
        sb.reverse();

        while(sb.length() > 1 && sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Q401_RemoveKdigits m = new Q401_RemoveKdigits();
        m.removeKdigits("1432219",3);
    }
}

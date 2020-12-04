package string;

import java.util.*;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/25 18:05
 */

public class Q1370_SortString {
    public String sortString(String s) {
        StringBuffer res = new StringBuffer();
        List<Character> list = new ArrayList<Character>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            list.add(s.charAt(i));
        }
        list.sort((a, b) -> a.compareTo(b));
        char cha;
        while(!list.isEmpty()){
            //1.正序处理
            cha = list.get(0);
            res.append(cha);
            list.remove((Character) cha);
            ListIterator it = list.listIterator();
            while(it.hasNext()){
                Character ch = (Character) it.next();
                if(ch > cha) {
                    cha = ch;
                    res.append(ch);
                    it.remove();
                }
            }
            //2.倒叙处理，取当前列表中最大的字符
            if(!list.isEmpty() && it.hasPrevious()){
                //重置cha
                cha =(Character) it.previous();
                res.append(cha);
                it.remove();
            }

            while(it.hasPrevious()){
                Character ch = (Character) it.previous();
                if(ch < cha){
                    res.append(ch);
                    cha = ch;
                    it.remove();
                }
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        String s = "hrazkfsbswcsnqhozolsugvdlfrchxzxmxquxqjbywbpwkoohsopfhaimrjhrmvsppmepsulvqtmiqhutsdpstfzovkkdltihmfzqjgepvpiny";
        Q1370_SortString m =  new Q1370_SortString();
        m.sortString(s);
    }
}

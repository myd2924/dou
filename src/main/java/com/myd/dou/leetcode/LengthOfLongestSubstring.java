package com.myd.dou.leetcode;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/5/29 10:57
 * @Description: 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(queryLength(s));
        System.out.println(queryLength2(s));
    }

    public static int queryLength(String s){
        int begin = 0;
        int i = 0;
        int length = 0;
        int result = 0;
        while(i < s.length()){
            int pos = s.indexOf(s.charAt(i),begin);
            if(pos < i){
                if(result < length){
                    result = length;
                }

                if(result >= s.length()-pos-1){
                    return result;
                }

                length = i - pos -1;
                begin = pos +1;
            }
            length++;
            i++;
        }
        return length;
    }

    /**
     * java实现移动窗口
     * @param s
     * @return
     */
    public static int queryLength2(String s){
        int i=0;
        int j=0;
        int result = 0;
        int temp = 0;
        if(s.equals("") ){
            return 0;
        }
        if(s.equals(" ")){
            return 1;
        }
        while(j<s.length()){
            int pos = s.indexOf(s.charAt(j), i);
            if(pos < j){
                i= pos+1;
            }else{
                j++;
            }
            temp = j-i;
            if(temp > result){
                result = temp;
            }
        }
        return result;

    }
}

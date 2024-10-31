package org.alvin.leet.code;

import java.util.Deque;
import java.util.LinkedList;

public class Solution224 {

    /**
     * 因为这道题目里面只有+-法， 所以本质上就是如何除去-(，使得里面的符号位互换
     * 1-（3+4） = 1-3-4;  所以本质上就是 ans = ans + num * sign(这个就是需要根据括号来决定是+1 还是-1)
     * 这个值和前面的（ 以及（前面的符号有关系。所以整体思路如下
     * 一旦遇到（, 就需要记录当前的符号位， 下一次被记录的符号和上一次的符号有关系。
     * 一旦遇到） ， 就需要弹出符号位，使用上一层符号位
     * 所以这个思路并不是先计算（）， 然后在计算外面， 而是重做到右一次计算。 如果有* / 这个逻辑就有问题了。
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        // 1-（3+4） =  0 +（1-（3+4））， 所以本质上认为就是相加
        ops.push(1);
        // 符号位
        int sign = 1;
        int ret =0;
        int n = s.length();
        int i =0;
        char[] sCharArray = s.toCharArray();
        while(i < n){
            // 无效字符过滤
            if(sCharArray[i] == ' '){
                i++;
            }else if(sCharArray[i] == '+'){
                // 获取当前的符号位
                sign = ops.peek();
                i++;
            }else  if(sCharArray[i] == '-'){
                // 符号需要颠倒符号位
                sign = -ops.peek();
                i++;
            }else  if (sCharArray[i] == '('){
                // 需要保存（前的符号位
                ops.push(sign);
                i++;
            }else  if(sCharArray[i] == ')'){
                // 最顶层的符号位结束使用
                ops.pop();
                i++;
            }else{
                //计算连续的数字字符 例如 798
                long num = 0;
                while(i < n && Character.isDigit(sCharArray[i])){
                    num = num * 10 + sCharArray[i]-'0';
                    i++;
                }
                ret += (int) (sign * num);
            }
        }
        return ret;
    }

    public int calculate1(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;
        long ans = 0;
        int n = s.length();
        char[] sCharArray = s.toCharArray();
        int i =0;
        while(i < n ){
            char c = sCharArray[i];
            if (c == ' ') {
                i++;
            }else if(c  == '-'){
                sign = - ops.peek();
                i++;
            }else if(c =='+'){
                sign =  ops.peek();
                i++;
            } else if (c ==')') {
                ops.pop();
                i++;
            } else if (c == '(') {
                ops.push(sign);
                i++;
            }else {
                long num = 0;
                while(i < n && Character.isDigit(sCharArray[i])){
                    num = num * 10 + sCharArray[i] -'0';
                    i++;
                }
                ans  = ans + sign * num;
            }

        }

        return (int) ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution224().calculate("2147483647"));
    }

}

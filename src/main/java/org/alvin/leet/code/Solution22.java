package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n,n,"");
        return ans;
    }

    public void generateParenthesis(int left, int right, String pattern) {
        if(left==0 && right == 0){
            ans.add(pattern);
            return;
        }

        if(left > 0){
            generateParenthesis(left-1, right, pattern+"(");
        }
        if(right > left){
            generateParenthesis(left, right-1, pattern+")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }
}

package org.alvin.leet.code;

public class Solution58 {

    public int lengthOfLastWord(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >=0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (ans != 0) {
                    return ans;
                } else {
                    continue;
                }
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution58().lengthOfLastWord("a"));
    }

}

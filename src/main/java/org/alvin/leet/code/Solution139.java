package org.alvin.leet.code;

import java.util.*;

public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        // 初始化认为0满足条件
        dp[0] = true;
        // 注意需要递归到s.length 为止
        for (int i = 1; i <= s.length(); i++) {
            // 遍历字典， 最后一段字符必须满足和字典相同，并且前半段也需要满足条件
            for (int k = 0; k < wordDict.size(); k++) {
                String word = wordDict.get(k);
                int index = i - word.length();
                if (index >= 0 && dp[index] && wordSet.contains(s.substring(index, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> words = Arrays.asList("leet", "code");
        System.out.println(new Solution139().wordBreak(s, words));
    }
}

package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words[0].length();
        int m = words.length;
        int length = n * m;
        List<Integer> ans = new ArrayList<>();
        //本质上所有的分词种类只有n种， i=step分词结果和i=0是一样的。
        for (int i = 0; i < n; i++) {

            // 后面不足length的长度就不需要继续了
            if (i + length > s.length()) {
                break;
            }

            // 每次分词都需要重新初始化differ, 每次取length个字符， 分词m段
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }

            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
            }

            int differCount = 0;
            for (Map.Entry<String, Integer> entry : differ.entrySet()) {
                if (entry.getValue() != 0) {
                    differCount++;
                }
            }

            if (differCount == 0) {
                ans.add(i);
            }

            // 开始滑动窗口, 初始位置是i， 每次移动n个字符
            for (int k = i; k <= s.length() - length - n; k = k + n) {
                // 上一个词
                String word = s.substring(k, k + n);
                differ.put(word, differ.getOrDefault(word, 0) - 1);

                Integer count = differ.get(word);
                if (count == 0) {
                    //从不同变成了相同
                    differCount--;
                } else if (count == -1) {
                    //从相同变成了不同
                    differCount++;
                }

                word = s.substring(k + length, k + length + n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);

                count = differ.get(word);
                if (count == 0) {
                    //从不同变成了相同
                    differCount--;
                } else if (count == 1) {
                    //从相同变成了不同
                    differCount++;
                }

                if (differCount == 0) {
                    // 目前k是离开的位置， 所以匹配的位置需要加n
                    ans.add(k + n);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"word","good","best","good"};
        String s = "wordgoodgoodgoodbestword";
        List<Integer> substring = new Solution30().findSubstring(s, words);
        System.out.println(substring);
    }
}

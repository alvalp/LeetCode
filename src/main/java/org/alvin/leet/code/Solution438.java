package org.alvin.leet.code;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        List<Integer> ans = new ArrayList<>();

        //异常情况
        if (slen < plen) {
            return ans;
        }

        // 26个字母的数量
        int[] count = new int[26];

        //plen 是滑动窗口的大小， 固定窗口, 先计算初始窗口的差异
        for (int i = 0; i < plen; i++) {
            count[sArray[i] - 'a']++;
            count[pArray[i] - 'a']--;
        }

        // 统计差异值有多少
        int differ = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                differ++;
            }
        }

        // 判断第一个位置
        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < slen - plen; i++) {
            // s[i] 移除窗口, 1->0  0-> -1 只有这两种情况需要考虑
            int index = sArray[i] - 'a';
            count[index]--;

            if (count[index] == -1) {
                //从相同变成了不同
                differ++;
            } else if (count[index] == 0) {
                // 从不同变成了相同
                differ--;
            }

            // 新字符移入窗口个， 0->1  -1-> 0 两种情况
            int newIndex = sArray[i + plen] - 'a';
            count[newIndex]++;
            if (count[newIndex] == 1) {
                differ++;
            } else if (count[newIndex] == 0) {
                differ--;
            }

            if (differ == 0) {
                ans.add(i + 1);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = new Solution438().findAnagrams("aa","bb");
        System.out.println(anagrams);
    }

}

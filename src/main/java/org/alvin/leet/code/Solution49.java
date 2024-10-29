package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49 {

    //异位词的字母个数是相同的。 所以将字符和个数拼接成唯一key来解决
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs){
            char[] charArray = string.toCharArray();
            int[] array =new int[26];
            for (char c : charArray){
                array[c - 'a'] = array[c -'a']+1;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                if(array[i] != 0){
                    key.append(i).append("_").append(array[i]).append(",");
                }
            }

            List<String> values = map.getOrDefault(key.toString(), new ArrayList<>());
            values.add(string);
            map.put(key.toString(), values);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution49().groupAnagrams(strs));
    }
}

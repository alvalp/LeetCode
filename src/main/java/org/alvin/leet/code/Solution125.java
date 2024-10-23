package org.alvin.leet.code;

public class Solution125 {
    public boolean isPalindrome(String s) {
        // 双指针， 往中间走
        char[] charArray = s.toLowerCase().toCharArray();
        for (int i = 0, k = s.length() - 1; i < k; i++, k--) {
            // 注意边界条件
            while (i < s.length() && !isValid(charArray[i])) {
                i++;
            }

            while (k > 0 && !isValid(charArray[k])) {
                k--;
            }
            if (i < s.length() && k > 0 && charArray[i] != charArray[k]) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        System.out.println(new Solution125().isPalindrome("._"));
    }
}

package org.alvin.leet.code;

import java.util.*;

public class Solution1019 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        // 单调队列， 为了同时保存下标， 需要用数组. 0表示值， 1表示下标
        Stack<int[]> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        int index = 0;
        while (head != null) {
            int value = head.val;
            // 每次都先添加0， 默认后续没有更大值， 同时确保下面的取值不会越界
            ans.add(0);

            // 循环取值
            while (!stack.isEmpty() && stack.peek()[0] < value) {
                int[] node = stack.pop();
                ans.set(node[1], value);
            }

            stack.push(new int[]{value, index});
            head = head.next;
            index++;
        }

        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}

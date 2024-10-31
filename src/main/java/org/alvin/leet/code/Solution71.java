package org.alvin.leet.code;

import java.util.Stack;

public class Solution71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String p : split) {
            //  当前路径，直接过滤
            if (".".equals(p)) {
                continue;
            }

            // 返回到上级路径
            if ("..".equals(p)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            // 保存目录值
            if (!p.isEmpty()) {
                stack.push(p);
            }
        }
        // 拼接完整路径
        String ans = "";
        while (!stack.isEmpty()) {
            ans = "/" + stack.pop() + ans;
        }
        return ans.isEmpty() ? "/" : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution71().simplifyPath("/../"));
    }
}

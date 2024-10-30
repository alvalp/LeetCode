package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {

    List<List<Integer>> edges;
    int[] indeg;

    // 通过广度优先搜索， 结合有向有环图。 通过构建节点的入度， 将入度为0的节点还是搜索。
    // 课程A 依赖于先学课程B 则存在 B-> A。 所以A的入度为1， 依赖的越多入度越大。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        // 初始化所有的节点， 用于存储，依赖当前课程的课程。 A -> B .
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            //先学1， 再学0 . 有向图  1->0
            edges.get(info[1]).add(info[0]);
            // 0的入度+1,
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的， 表示可以先学习
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visitd = 0;
        while (!queue.isEmpty()) {
            ++visitd;
            // 取出一个节点
            int u = queue.poll();
            // 获取依赖该节点的节点
            for (int v : edges.get(u)) {
                // 因为u已经学完， 所以入度可以减一
                --indeg[v];
                // 如果没有入度了， 表示可以学该课程
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visitd == numCourses;
    }
}

package org.alvin.leet.code;

import java.util.*;

public class Solution210 {

    List<List<Integer>> edges = new ArrayList<>();
    int[] indeg;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            indeg[info[0]]++;
            edges.get(info[1]).add(info[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            ans.add(u);
            for (Integer v : edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (ans.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}

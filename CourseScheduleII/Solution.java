package CourseScheduleII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by whong53 on 2/27/17.
 */
public class Solution {
    /**
     * There are a total of n courses you have to take, labeled from 0 to n - 1.
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
     * There may be multiple correct orders, you just need to return one of them.
     * If it is impossible to finish all courses, return an empty array.
     *
     * @param numCourses    a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] nodes = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>();
        initGraph(nodes, adjs, prerequisites);
        return solve(nodes, adjs);
    }

    private void initGraph(int[] nodes, List<List<Integer>> adjs, int[][] prerequisites) {
        int n = nodes.length;
        while (n-- > 0) {
            adjs.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            nodes[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }

    private int[] solve(int[] nodes, List<List<Integer>> adjs) {
        int[] result = new int[nodes.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 0) {
                queue.offer(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            result[i++] = from;
            for (int to : adjs.get(from)) {
                nodes[to]--;
                if (nodes[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return i == nodes.length ? result : new int[0];
    }
}

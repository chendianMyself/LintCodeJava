package KClosestPoints;

import Util.Point;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by whong53 on 2/27/17.
 */
public class Solution {
    /**
     * Given some points and a point origin in two dimensional space,
     * find k points out of the some points which are nearest to origin.
     * Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
     *
     * @param points a list of points
     * @param origin a point
     * @param k      an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<Point>(
                (a, b) -> {
                    int diff = getDist(b, origin) - getDist(a, origin);
                    if (diff == 0) {
                        diff = b.x - a.x;
                    }
                    if (diff == 0) {
                        diff = b.y - a.y;
                    }
                    return diff;
                }
        );

        for (Point point : points) {
            queue.add(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        k = queue.size();
        Point[] result = new Point[k];
        while (!queue.isEmpty()) {
            result[--k] = queue.poll();
        }
        return result;
    }

    private int getDist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}

class Solution2 {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    private Point globalOrigin = null;

    public Point[] kClosest(Point[] points, Point origin, int k) {
        globalOrigin = origin;
        PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDist(b, globalOrigin) - getDist(a, globalOrigin);
                if (diff == 0)
                    diff = b.x - a.x;
                if (diff == 0)
                    diff = b.y - a.y;
                return diff;
            }
        });
        for (Point point : points) {
            queue.add(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        k = queue.size();
        Point[] result = new Point[k];
        while (!queue.isEmpty()) {
            result[--k] = queue.poll();
        }
        return result;
    }

    private int getDist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
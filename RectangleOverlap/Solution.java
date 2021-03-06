package RectangleOverlap;

import Util.Point;

/**
 * Created by whong53 on 2/27/17.
 */
public class Solution {
    /**
     * Given two rectangles, find if the given two rectangles overlap or not.
     *
     * @param l1 top-left coordinate of first rectangle
     * @param r1 bottom-right coordinate of first rectangle
     * @param l2 top-left coordinate of second rectangle
     * @param r2 bottom-right coordinate of second rectangle
     * @return true if they are overlap or false
     */
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        if (l1.x > r2.x || r1.x < l2.x || r1.y > l2.y || l1.y < r2.y) {
            return false;
        }
        return true;
    }
}

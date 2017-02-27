package LongestPalindrome;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by whong53 on 2/27/17.
 */
public class Solution {
    /**
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (set.size() > 0) {
            return s.length() - set.size() + 1;
        } else {
            return s.length() - set.size();
        }
    }
}

package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/20.
 */
/**
 * 这道题最重要的是no bug，而不是性能
 * 面试中要给所有cases cover到
 * 下面的写法足够简单和直观了
 * DP也可，但是不推荐
 */

/**
 * TestCases
 * ".*"是可以匹配任意字符串的，因为".*"表示0个或多个"."，而"."是可以匹配任意字符的
 */
public class RegularExpressionMatching {

    // 耗时153ms
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() == 1) {
            return s.length() == 1 && isEquals(s, p);
        }

        if (p.charAt(1) != '*') {
            return s.length() > 0 && isEquals(s, p) && isMatch(s.substring(1), p.substring(1));
        } else {
            if (s.length() > 0) {
                if (isEquals(s, p)) {
                    return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
                } else {
                    return isMatch(s, p.substring(2));
                }
            } else {
                return isMatch(s, p.substring(2));
            }
        }
    }

    private boolean isEquals(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }
}

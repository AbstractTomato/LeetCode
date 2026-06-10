package SlideWindow;


import java.util.Arrays;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class checkInclusion {
    public boolean checkInclusion1(String s1, String s2){
        int m = s1.length();
        if (s2 == null || s2.isEmpty() || s2.length() < m){
            return false;
        }

        int[] arrS1 = new int[26];
        char[] chars = s1.toCharArray();
        for (char c : chars) {
            arrS1[c - 'a']++;
        }

        int[] arrS2 = new int[26];
        char[] charArray = s2.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            arrS2[charArray[i] - 'a']++;

            if (i < m - 1){
                continue;
            }

            if (Arrays.equals(arrS1, arrS2)){
                return true;
            }

            arrS2[charArray[i - m + 1] - 'a']--;

        }

        return false;
    }
}

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


    /**
     * 定义一个变量less,表示s1与窗口内不同字母数量的差异,还没进入窗口时,less表示s1中不同字母的数量
     * 数组arr索引对应字母,索引对应的值表示对应字母出现的数量
     * 如果arr[idx] == 0, 表示arr的idx对应的字母的数量与窗口内的一致,此时less--
     * 如果窗口还未成型,则跳过此轮
     * 离开窗口的字母对应的索引out, 如果arr[out] == 0, 则此时不会满足条件,arr[out]++; less++
     */
    public boolean checkInclusion2(String s1, String s2){

        int len = s1.length();
        if (s2 == null || s2.isEmpty() || s2.length() < len){
            return false;
        }

        //定义一个变量less,表示字符串s1中不同字母的数量
        int less = 0;
        int[] arr = new int[26];
        for (int i = 0; i < len; i++){
            int idx = s1.charAt(i) - 'a';

            if (arr[idx] == 0){
                less++;
            }

            arr[idx]++;
        }

        char[] s = s2.toCharArray();
        for (int right = 0; right < s.length; right++){
            int idx = s[right] - 'a';
            arr[idx]--;
            if (arr[idx] == 0){
                less--;
            }

            if (less == 0){
                return true;
            }

            int left = right - len + 1;
            if (left < 0){
                continue;
            }

            int out = s[left] - 'a';
            if (arr[out] == 0){
                less++;
            }
            arr[out]++;
        }

        return false;
    }
}

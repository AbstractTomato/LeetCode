package Hash;


/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
 */
public class isAnagram {
    public boolean isAnagram(String s, String t){
        //首先判断是否为空
        if (s == null || t == null || s.isEmpty() || t.isEmpty()){
            return false;
        }

        if (s.length() != t.length()){
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
            arr2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] - arr2[i] != 0){
                return false;
            }
        }

        return true;
    }
}

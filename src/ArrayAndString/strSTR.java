package ArrayAndString;


/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class strSTR {
    //暴力解法
    public int strStr1(String haystack, String needle){
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0 || haystack.length() < needle.length()){
            return -1;
        }

        int len = needle.length();
        char[] charArray = needle.toCharArray();
        for (int i = 0; i < haystack.length() - len + 1; i++){
            int index = i;
            for (int j = 0; j < charArray.length; j++) {
                if (haystack.charAt(index) - charArray[j] != 0){
                    break;
                }
                index++;
            }
            if (index - i == len){
                return i;
            }
        }
        return -1;
    }
}

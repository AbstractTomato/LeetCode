package TwoPoint;


/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class isPalindrome {
    public boolean isPalindrome(String s){
        String string = cleanString(s);

        return judgePalindrome(string);
    }

    private String cleanString(String s){
        String s1 = s.trim().toLowerCase();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c - 'a' >= 0 && c - 'z' <= 0){
                builder.append(c);
            }
        }

        return builder.toString();
    }

    private boolean judgePalindrome(String s){
        if (s == null || s.isEmpty()){
            return true;
        }
        int len = s.length();
        int left = 0;
        int right = len - 1;
        while (left <= right){
            if (s.charAt(left) - s.charAt(right) != 0){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

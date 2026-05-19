package ArrayAndString;


/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class lengthOfLastWord {
    public int lengthOfLastWord(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        int end = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) - ' ' != 0){
                end = i;
                break;
            }
        }

        int start = -1;
        for (int i = end - 1; i >= 0; i--){
            if (s.charAt(i) - ' ' == 0){
                start = i;
                break;
            }
        }

        return end - start;
    }
}

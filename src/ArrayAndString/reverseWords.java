package ArrayAndString;


/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class reverseWords {
    public String reverseWords(String s){

        //首先排除字符串的前后空格
        s = s.trim();

        //定义单词的首尾
        int start = s.length() - 1;
        int end = start;

        StringBuilder builder = new StringBuilder();

        //倒序遍历,找到第一个空格,因为此时start和end指向的肯定是单词的最后一个字母
        while (start >= 0){
            //找到第一个空格
            while (start >= 0 && s.charAt(start) != ' '){
                start--;
            }
            //此时找到第一个空格,将单词加进去
            //start对应的是第一个空格
            builder.append(s.substring(start + 1, end + 1)).append(" ");

            //此时跳过单词之间的空格
            while (start >= 0 && s.charAt(start) == ' '){
                start--;
            }
            end = start;
        }

        return builder.toString().trim();
    }
}

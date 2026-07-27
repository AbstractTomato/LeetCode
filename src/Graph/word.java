package Graph;

import java.util.*;

/**
 * 字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
 * 如果不存在这样的转换序列，返回 0 。
 */
public class word {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)){
            return 0;
        }

        char[] chars = new char[26];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('a' + i);
        }

        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int count = 1;

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)){
                    return count;
                }
                char[] charArray = cur.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char original = charArray[j];
                    for (char aChar : chars) {
                        if (original == aChar){
                            continue;
                        }
                        charArray[j] = aChar;
                        String next = new String(charArray);
                        if (wordSet.contains(next)){
                            queue.offer(next);
                            wordSet.remove(next);
                        }
                    }
                    charArray[j] = original;
                }
            }

            count++;
        }

        return 0;
    }
}

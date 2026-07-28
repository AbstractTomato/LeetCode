package DicTree;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 */
public class findWords {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words){
        List<String> ans = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //回朔DFS
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> ans) {
        //递归的边界条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }

        //拿到该格子上的字符,方便后面回朔
        char c = board[i][j];
        //判断该格子是否被访问过 || 该格子上的字符对应的trie树中有没有后续
        if (c == '#' || node.children[c - 'a'] == null){
            return;
        }

        //深入下一层
        node = node.children[c - 'a'];
        //判断是否满足条件
        if (node.word != null){
            ans.add(node.word);
            //置null,防止重复添加
            node.word = null;
        }

        //标记格子已访问
        board[i][j] = '#';

        dfs(board, i + 1, j, node, ans);
        dfs(board, i - 1, j, node, ans);
        dfs(board, i, j + 1, node, ans);
        dfs(board, i, j - 1, node, ans);

        //回朔
        board[i][j] = c;

    }

    private TrieNode buildTrie(String[] words) {
        //头层节点
        TrieNode root = new TrieNode();
        //遍历字符串数组,依次将其添加到trie树中
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            //结束后添加单词
            node.word = word;
        }

        return root;
    }
}

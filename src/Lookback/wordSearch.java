package Lookback;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；
 * 否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class wordSearch {
    public  boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }

        int index = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, index)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()){
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }



        char c = board[i][j];
        board[i][j] = '#';

        boolean flag = dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i - 1, j, word, index + 1)
                || dfs(board, i, j + 1, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1);

        board[i][j] = c;

        return flag;
    }
}

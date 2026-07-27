package DicTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Trie {
    //暴力
    /*Map<String, Set<String>> words;
    Set<String> set;
    public Trie() {
        words = new HashMap<>();
        set = new HashSet<>();
    }

    public void insert(String word) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            String prefix = word.substring(0, i + 1);
            words.put(prefix, new HashSet<>());
        }

        for (int i = 0; i < length; i++) {
            String prefix = word.substring(0, i + 1);
            words.get(prefix).add(word);
        }

        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        return words.containsKey(prefix);
    }*/

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isFinished = false;
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isFinished = true;
    }

    public boolean search(String word){
        TrieNode node = findNode(word);
        return node != null && node.isFinished;
    }

    public boolean startWith(String word){
        return findNode(word) != null;
    }


    private TrieNode findNode(String str){
        TrieNode node = root;
        for (char c : str.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null){
                return null;
            }
            node = node.children[idx];
        }

        return node;
    }
}

package DicTree;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；
 * 否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 */
public class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary(){
        root = new TrieNode();
    }

    public void addWord(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int next = c - 'a';
            if (node.children[next] == null){
                node.children[next] = new TrieNode();
            }
            node = node.children[next];
        }
        node.isEnd = true;
    }

    public boolean search(String word){
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()){
            return node.isEnd;
        }
        char c = word.charAt(index);

        if (c != '.'){
            if (node.children[c - 'a'] == null){
                return false;
            }
            return dfs(node.children[c - 'a'], word, index + 1);
        }else {
            for (TrieNode child : node.children) {
                if (child != null){
                    if (dfs(child, word, index + 1)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

}

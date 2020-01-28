package practice.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 19.10.19.
 * <p>
 * 前缀树结构
 */
public class TrieTree {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.addString("abc");
    trie.addString("bcd");
    trie.addString("acd");

    trie.printContent();
  }

  public static class TrieNode {
    public int path;
    public int end;
    public TrieNode[] nodes;
    public char[] values;

    public TrieNode() {
      this.path = 0;
      this.end = 0;
      this.nodes = new TrieNode[26];
      this.values = new char[26];
    }

    @Override
    public String toString() {
      return "TrieNode{" +
        "path=" + path +
        ", end=" + end +
//        ", nodes=" + Arrays.toString(nodes) +
        ", values=" + Arrays.toString(values) +
        '}';
    }
  }

  public static class Trie {
    private TrieNode root;

    public void addString(String str) {
      buildTrie(str);
    }

    private void buildTrie(String str) {
      if (root == null) {
        root = new TrieNode();
      }
      char[] chars = str.toCharArray();
      TrieNode cur = root;
      for (char c : chars) {
        if (cur.values[c - 'a'] != 0) {
          cur.path++;
          cur = cur.nodes[c - 'a'];
        } else {
          cur.values[c - 'a'] = c;
          cur.nodes[c - 'a'] = new TrieNode();
          cur = cur.nodes[c - 'a'];
        }
      }
      cur.end++;
    }

    public void printContent() {
      if (root == null) {
        return;
      }
      Queue<TrieNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        TrieNode cur = queue.poll();
        System.out.println(cur);
        for (TrieNode n : cur.nodes) {
          if (n != null) {
            queue.add(n);
          }
        }
      }
    }
  }
}

package leetcode;

import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {

    class Node {
        char c;
        int row;
    
        public Node(char c, int row) {
            this.c = c;
            this.row = row;
        }
    
        @Override
        public String toString() {
            return String.format("[%c,%d]", c, row);
        }
    }

    public String convert(String s, int numRows) {
        int row = 1;

        ArrayList<Node> nodes = new ArrayList<>();

        int direction = 1;// 1:down, -1:right
        for (int i = 0; i < s.length(); i++) {
            if (row == 1) {
                direction = 1;
            } else if (row == numRows) {
                direction = -1;
            }
            Node node = new Node(s.charAt(i), row);
            nodes.add(node);
            row += direction;
            // if numRow == 1
            if(row > numRows){
                row = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        row = 1;
        while(row <= numRows){
            for(int i=0; i<nodes.size(); i++){
                Node node = nodes.get(i);
                if(node.row == row){
                    sb.append(node.c);
                }
            }
            row++;
        }
        return sb.toString();
    }
}
// @lc code=end

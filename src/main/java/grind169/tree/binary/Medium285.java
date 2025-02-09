package grind169.tree.binary;

import java.util.Stack;

//[LeetCode] 285. Inorder Successor in BST 二叉搜索树中的中序后继节点
//https://www.cnblogs.com/grandyang/p/4913869.html
public class Medium285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        boolean found = false;
        TreeNode  curr = root;

        while(curr != null || !stack.isEmpty()){
            // 先遍歷至該節點的最左節點
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(found) return curr;
            if(curr == p) found = true;
            curr = curr.right;
        }
        return null;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

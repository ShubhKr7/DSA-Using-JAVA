/*
 104. Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Constraints:
The number of nodes in the tree is in the range [0, 10^4].
-100 <= Node.val <= 100
 */

package leetcodeQuestions;
public class maxDepthOfATree {

    //Class to implement Tree
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val,TreeNode left, TreeNode right){this.val=val;this.left=left;this.right=right;}
    }

    //Function to insert nodes in a tree
    public static TreeNode insert(int[] nums, int idx){
        if(idx>=nums.length||nums[idx]==-1) return null;
        TreeNode root=new TreeNode(nums[idx]);
        root.left=insert(nums, 2*idx+1);
        root.right=insert(nums, 2*idx+2);
        return root;
    }

    //Function to find the maxdepth
    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return 1 + Math.max(lh,rh);
    }
    
    //Main Function
    public static void main(String[] args) {
        int nums[]={1,2,-1};
        TreeNode root=insert(nums,0);
        System.out.println(maxDepth(root));
    }
}

/*
 110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-10^4 <= Node.val <= 10^4
 */

package leetcodeQuestions;
public class balancedBinaryTree {
    
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

    public static boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }
    public static int height(TreeNode root){
        if(root==null) return 0;
        int lh=height(root.left);
        if(lh==-1) return -1;
        int rh=height(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return 1+Math.max(lh,rh);
    }

    //Main Function
    public static void main(String[] args) {
        int nums[]={1,2,-1};
        TreeNode root=insert(nums,0);
        System.out.println(isBalanced(root));
    }
}

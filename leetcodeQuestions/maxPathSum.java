/*
 124. Binary Tree Maximum Path Sum

 A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
 A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

Constraints:
The number of nodes in the tree is in the range [1, 3 * 10^4].
-1000 <= Node.val <= 1000
 */

package leetcodeQuestions;
public class maxPathSum {

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

    public static int maxSum(TreeNode root) {
        int max[]=new int[1];
        max[0]=Integer.MIN_VALUE;
        int res=recur(root,max);
        return Math.max(max[0],res);
    }

    public static int recur(TreeNode root, int []max){
        if(root==null) return 0;
        int lh=Math.max(recur(root.left,max),0);
        int rh=Math.max(recur(root.right,max),0);
        max[0]=Math.max(max[0],lh+rh+root.val);
        return root.val + Math.max(lh,rh);
    }
    

    //Main Function
    public static void main(String[] args) {
        int nums[]={1,2,-1};
        TreeNode root=insert(nums,0);
        System.out.println(maxSum(root));
    }
}

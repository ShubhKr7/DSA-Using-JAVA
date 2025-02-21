/*
 543. Diameter of Binary Tree

 Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1
 
Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-100 <= Node.val <= 100
 */

package leetcodeQuestions;
public class diameterOfATree {
    
    //TreeNode class
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right){this.val=val;this.left=left;this.right=right;}
    }

    //Function to insert nodes into the Binary Tree
    public static TreeNode insert(int []nums, int idx){
        if(idx>=nums.length||nums[idx]==-1) return null;
        TreeNode root=new TreeNode(nums[idx]);
        root.left=insert(nums, 2*idx+1);
        root.right=insert(nums, 2*idx+2);
        return root;
    }

    //Function to find the diameter of the Tree
    public static int find(TreeNode root){

        //Using an array coz it can be referenced in java just like a global variable
        int []d=new int[1];
        dia(root,d);

        //Return the maximum diameter
        return d[0];
    }
    
    //Function to find the diameter using recursion
    public static int dia(TreeNode root, int []d){
        if(root==null) return 0;

        //Find left height
        int lh=dia(root.left,d);

        //Find right height
        int rh=dia(root.right,d);

        //Find the maximum diameter and store it
        d[0]=Math.max(d[0],lh+rh);

        //Return the max path length and include the current path as well
        return 1+ Math.max(lh,rh);
    }

    public static void main(String[] args) {
        // int nums[]={1,2,3,4,5,-1,-1};
        int []nums={1,2,-1};
        TreeNode root=insert(nums,0);

        System.out.println(find(root));
    }
}

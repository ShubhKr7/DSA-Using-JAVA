/*
 94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

package leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class binaryTreeInorderTraversal {

    //Making a class for treenode
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; left=right=null; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }}

            //Finding inorder traversal of the inorder traversal
            public static List<Integer> inorderTraversal(TreeNode root) {
                List<Integer>res=new ArrayList<>();
                in( root,res);
                return res;
    }

            //Recursive function to find inorder traversal
            public static void in(TreeNode root,List<Integer>list){
                if(root==null) return;
                in(root.left,list);
                list.add(root.val);
                in(root.right,list);
            }

            //Making an insert function which puts values of array into nodes of a binary tree and creating a binary tree
             public static TreeNode insert(int []nums, int idx){
                    if(idx>=nums.length||nums[idx]==-1){
                        return null;
                    }
                    TreeNode root=new TreeNode(nums[idx]);
                    root.left=insert(nums, idx+1);
                    root.right=insert(nums, idx+2);
                    return root;
                }


    //Main function
    public static void main(String[] args) {

        //Making an array which contains -1 for null values and node values
        int nums[]={1,-1,2,3};

        //making a binary tree
        TreeNode root=insert(nums, 0);

        //Finding the inorder traversal and storing it in a list of lists
        List<Integer>res=inorderTraversal(root);

        //Printing result
        System.out.println(res);

    }
}

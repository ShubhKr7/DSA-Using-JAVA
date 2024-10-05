/*
 100. Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:
The number of nodes in both trees is in the range [0, 100].
-10^4 <= Node.val <= 10^4
 */

package leetcodeQuestions;

public class sameTree {

    //Making treenode class
    public static class TreeNode{
        int val; 
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right){this.val=val;this.left=left;this.right=right;}
    }
    
    //Making an insert function to construct a binary tree
    public static TreeNode insert(int []nums, int idx){
        if(idx>=nums.length||nums[idx]==-1) return null;
        TreeNode root=new TreeNode(nums[idx]);
        root.left=insert(nums, idx+1);
        root.right=insert(nums, idx+2);
        return root;
    }

    //Function to find if the tree is same or not
    public static boolean isSame(TreeNode p, TreeNode q){

        //If both the nodes are equal then return true
        if(p==q) return true;

        //Else if anything is different then return false
        else if((p==null&&q!=null)||(p!=null&&q==null)||(p.val!=q.val)) return false;

        //Recursive call to left and right elements
        return isSame(p.left, q.left)&&isSame(p.right, q.right);
    }

    //Main Function
    public static void main(String[] args) {

        //Array to store elements of tree 1
        int nums1[]={1,2,3};

        //Array to store elements of tree 2
        int nums2[]={1,2,-1,-1,3};

        //Making tree 1
        TreeNode tree1=insert(nums1, 0);

        //Making tree 2
        TreeNode tree2=insert(nums2, 0);

        //Printing result
        System.out.println(isSame(tree1,tree2));
    }
}

/*
 112. Path Sum

 Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */

package leetcodeQuestions;
public class pathSum {

    //Making treenode class
    public static class TreeNode{
        int val; 
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right){this.val=val;this.left=left;this.right=right;}
    }
    
    //Making an insert function to construct a binary tree
    public static TreeNode insert(int []nums, int idx){
        if(idx>=nums.length||nums[idx]==-1) return null;
        TreeNode root=new TreeNode(nums[idx]);
        root.left=insert(nums, 2*idx+1);
        root.right=insert(nums, 2*idx+2);
        return root;
    }

    //Function to check if a path with target sum exists or not
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        
        //If no node is present in the tree then return false
        if(root==null) return false;

        //Calling the recursive function
        return recur(root,targetSum);
    }

    //Function to do the recursive calls
    static boolean recur(TreeNode root, int targetSum){

        //If the root is null then we have reached the wrong node
        if(root==null) return false;

        //If the target sum is exactly equal to the value of current node and this is a leaf node then we have found our path
        if(root.left==null&&root.right==null&&root.val==targetSum) return true;

        //Else make recursive calls to left and right of the tree and subtract the current value of the node as well from target sum
        return recur(root.left,targetSum-root.val)||recur(root.right,targetSum-root.val);
    }    

    //Main Function
    public static void main(String[] args) {
        int nums1[]={5,4,8,11,-1,13,4,7,2,-1,-1,-1,1};

        //Making tree 
        TreeNode tree1=insert(nums1, 0);
        System.out.println(hasPathSum(tree1, 22));
    }
}

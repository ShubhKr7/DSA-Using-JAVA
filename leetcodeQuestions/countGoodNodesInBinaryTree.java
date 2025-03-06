/*
 1448. Count Good Nodes in Binary Tree

 Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

Example 2:
Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

Example 3:
Input: root = [1]
Output: 1
Explanation: Root is considered as good.

Constraints:
The number of nodes in the binary tree is in the range [1, 10^5].
Each node's value is between [-10^4, 10^4].
 */

package leetcodeQuestions;
public class countGoodNodesInBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right){this.val=val;this.right=right;this.left=left;}
    }

    //Function to insert the elements into the binary tree
    static TreeNode insert(int []nums, int idx){
        if(idx>=nums.length||nums[idx]==-1) return null;
        TreeNode node=new TreeNode(nums[idx]);
        node.left=insert(nums, 2*idx+1);
        node.right=insert(nums, 2*idx+2);
        return node;
    }

    //Function to find the number of good nodes
    public static int goodNodes(TreeNode root) {
        if(root.left==null&&root.right==null) return 1;
        int max=root.val;
        int res=recur(root,max);
        return res;
    }


    static int recur(TreeNode root, int max){
        if(root==null) return 0;

        //Store the max value upto current node
        max=Math.max(max,root.val);

        //If root value is greater than or equal to maximum
        if(root.val>=max)

        //Then add one to the recursive calls
        return 1 +recur(root.left,max)+recur(root.right,max);

        //Otherwise make the recursive calls without considering this node
        return recur(root.left,max)+recur(root.right,max);
    }
    

    //Main Function
    public static void main(String[] args) {
        // int []nums={3,1,4,3,-1,1,5};
        // int []nums={3,3,-1,4,2};
        int []nums={1,0,0,0,1,-1,-1};
        TreeNode root=insert(nums,0);
        System.out.println(goodNodes(root));
    }
}

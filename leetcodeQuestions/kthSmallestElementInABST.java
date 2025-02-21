/*
 230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3 

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */

package leetcodeQuestions;
import java.util.PriorityQueue;
public class kthSmallestElementInABST {
    

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

    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        traversal(root,pq);
        while(k>1){
        pq.poll();k-=1;}
        return pq.poll();
    }

    public static void traversal(TreeNode root, PriorityQueue<Integer> pq){
        if(root==null) return;
        pq.add(root.val);
        traversal(root.left,pq);
        traversal(root.right,pq);
    }

    //Main Function
    public static void main(String[] args) {
        int nums[]={1,2,-1};
        TreeNode root=insert(nums,0);
        System.out.println(kthSmallest(root,2));
    }
}

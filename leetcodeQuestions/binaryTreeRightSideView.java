/*
 199. Binary Tree Right Side View

 Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,2,3,4,null,null,null,5]
Output: [1,3,4,5]

Example 3:
Input: root = [1,null,3]
Output: [1,3]

Example 4:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

package leetcodeQuestions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeRightSideView {
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

    //Function to find the right side view
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        //Here we are performing the normal BFS traversal
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root); q.offer(null);

        //But with 1 single twist
        while(q.size()>1){
            TreeNode node=q.poll();

            //If current node is null then add null to the queue again and continue
            if(node==null) {q.offer(null);continue;}

            //If the next element is null in the queue then this element is from the right side so add it to the result list
            if(q.peek()==null)
                res.add(node.val);
            
            //Now add the child nodes of the remaining nodes
            if(node.left!=null)
            q.offer(node.left);
            if(node.right!=null)
            q.offer(node.right);
        }

        //Return the resulting list which has only elements viewed from the right side
        return res;
    }
    
    //Main Function

    public static void main(String[] args) {
        // int nums[]={1,2,3,-1,5,-1,4};
        // int []nums={1,2,3,4,-1,-1,-1,5};
        int []nums={1,-1,3};
        TreeNode root=insert(nums,0);
        System.out.println(rightSideView(root));
    }
}

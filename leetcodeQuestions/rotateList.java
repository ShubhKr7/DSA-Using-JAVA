/*
 61. Rotate List

Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */

package leetcodeQuestions;
import java.util.*;
public class rotateList {

    //Making a ListNode class
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    //Function to rotate the list
    public static ListNode rotate(ListNode head, int k){

        rotateList obj = new rotateList();

        //Making a new Linked list of rotated array
        ListNode dummyHead=obj.new ListNode();
        ListNode tail=dummyHead;

        //An arraylist to store elements of linked list
        ArrayList<Integer> list= new ArrayList<>();
        ListNode p=head;

        //storing elements of linked list in the arraylist
        while(p!=null){
            list.add(p.val);
            p=p.next;
        }

        //If null list is passed then return null node
        if(list.size()==0) return dummyHead.next;

        //Inserting elements of rotated array into res
        int res[]=new int[list.size()];
        for(int i=0; i<list.size(); i+=1) {
            res[i]=list.get(i);
        }

        //Making k smaller than size of array coz rotating list by its length will return same list
        k%=res.length;

        //Rotating the array k times
        while(k>0){
            int temp=res[res.length-1];

            //Loop to rotate the array once
            for(int i=res.length-1; i>0; i-=1)
                res[i]=res[i-1];
            res[0]=temp;
            k-=1;
        }

        //Making the final linkedlist 
        for(int i:res){
            ListNode newNode = obj.new ListNode(i);
            tail.next=newNode;
            tail=tail.next;
        }

        //Returning result
        return dummyHead.next;
    }
    

    //Creating a function to display the list
    public static void display(ListNode head){
        while(head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }

    //Main function
    public static void main(String[] args) {
        rotateList obj = new rotateList();
        // ListNode first = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(3, obj.new ListNode(4, obj.new ListNode(5)))));
        ListNode first = obj.new ListNode();
        int k=8;
        System.out.println("Original lists:");
        display(first);

        System.out.println("Rotated list:");
        ListNode res=rotate(first,k);
        display(res);
    }
}

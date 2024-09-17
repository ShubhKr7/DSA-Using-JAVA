/*
 23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */

package leetcodeQuestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class mergeKSortedLists {
    
    //Making a ListNode class
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    public static ListNode merge(ListNode []lists){
        ArrayList<Integer> list =new ArrayList<>();
        for(ListNode i:lists){
            ListNode p = i;
            while(p!=null){
                list.add(p.val);
                p=p.next;
            }
        }
        Collections.sort(list);
        mergeKSortedLists obj = new mergeKSortedLists();
        ListNode dummyHead = obj.new ListNode();
        ListNode tail = dummyHead;
        int k=0;
        while(k<=list.size()-1){
            ListNode newNode = obj.new ListNode(list.get(k));
            tail.next=newNode;
            tail=tail.next;
            k+=1;
        }
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
        mergeKSortedLists obj = new mergeKSortedLists();
        ListNode first = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(3, obj.new ListNode(4, obj.new ListNode(5)))));
        ListNode second = obj.new ListNode(1, obj.new ListNode(3, obj.new ListNode(4)));
        ListNode third = obj.new ListNode(3, obj.new ListNode(5));
        ListNode head[] = {first,second,third};
        System.out.println("Original lists:");
        for(ListNode i: head) display(i);

        System.out.println("Final Lists:");
        ListNode res=merge(head);
        display(res);

    }
}

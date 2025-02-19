/*
 148. Sort List

 Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is in the range [0, 5 * 10^4].
-10^5 <= Node.val <= 10^5

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */

package leetcodeQuestions;
public class sortList {
    
 //Making a ListNode class
 public static class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next){this.val=val; this.next=next;}
}

    //Function to sort the Linked List
    //This is the normal Bubble Sort method which produces TLE at the last testcase
    // public static ListNode sort(ListNode head){
    //     if(head==null||head.next==null) return head;
    //     ListNode i=head;
    //     while(i.next!=null){
    //         ListNode j=i,minNode=j;
    //         minNode.val=i.val;
    //         while(j!=null){
    //             if (j.val<minNode.val)
    //                 minNode=j;
    //             j=j.next;}
    //         int t=i.val;
    //         i.val=minNode.val;
    //         minNode.val=t;
    //         i=i.next;
    //     }
    //     return head;
    // }

    //New Solution using merge sort which has O((N+N/2)log N)
    public static ListNode mergeSort(ListNode head){
        if(head==null||head.next==null) return head;

        ListNode mid=findMid(head);
        ListNode leftHead=head,rightHead=mid.next;
        mid.next=null;

        leftHead=mergeSort(leftHead);
        rightHead=mergeSort(rightHead);

        return merge(leftHead,rightHead);
    }

    //Function to find the mid of a Linked List
    public static ListNode findMid(ListNode head){
        ListNode slow=head,fast=slow.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //Function to merge two sorted Lists
    public static ListNode merge(ListNode head1, ListNode head2){
        ListNode res=new ListNode(0);
        ListNode tail=res;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                tail.next=head1;
                head1=head1.next;
            }
            else{
                tail.next=head2;
                head2=head2.next;
            }
            tail=tail.next;
        }
        if(head1!=null) tail.next=head1;
        else tail.next=head2;
        return res.next;
    }


//Creating a function to display the list
public static void display(ListNode head){
    while(head.next!=null){
        System.out.print(head.val+" -> ");
        head=head.next;
    }
    System.out.println(head.val);
}

    //Main Funtion
    public static void main(String[] args) {
        // ListNode first = new ListNode(10, new ListNode(2, new ListNode(13, new ListNode(40, new ListNode(5, new ListNode(-2))))));
        // ListNode first = new ListNode(10, new ListNode(8));
        ListNode first= new ListNode(10, new ListNode(3, new ListNode(9, new ListNode(4, new ListNode(12)))));
        System.out.println("Original List");
        display(first);

        System.out.println("Sorted List:");
        // first=sort(first);
        mergeSort(first);
        display(first); 
    }
}

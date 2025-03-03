/*
 92. Reverse Linked List II

 Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

Follow up: Could you do it in one pass?
 */

package leetcodeQuestions;
public class reverseLinkedListII {

    static class ListNode{
        int val;ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val,ListNode next){this.next=next;this.val=val;}
    }

    static void display(ListNode head){
        ListNode p=head;
        while(p.next!=null){
            System.out.print(p.val+"->");
            p=p.next;
        }
        System.out.println(p.val);
    }

    static ListNode reverse(ListNode head, int left, int right){
        if(head.next==null||left==right) return head;
        ListNode l=head,r=head;
        if(left==1){
            while(right>1){r=r.next;right-=1;}
            ListNode t=r.next;
            r.next=null;
            ListNode res=rev(head);
            if(t==null) return res;
            ListNode d=res;
            while(d.next!=null) d=d.next;
            d.next=t;
            return res;
        }
        while(left>1||right>1){
            if(left>1) {l=l.next;left-=1;}
            if (right>1) {r=r.next;right-=1;}
        }
        ListNode prev=head,n;
        while(l.next!=head.next&&prev.next!=l) prev=prev.next;
        prev.next=null;
        n=r.next;
        r.next=null;
        ListNode res=rev(l);
        prev.next=res;
        ListNode d=res;
        while(d.next!=null) d=d.next;
        d.next=n;
        return head;
    }

    //Function to reverse the List
    static ListNode rev(ListNode head){
        ListNode prev=null,next=null,curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        // ListNode head=new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5)))));
        ListNode head=new ListNode(3, new ListNode(5));
        int left=1,right=2;
        System.out.println("Before reversal");
        display(head);
        head=reverse(head,left,right);
        System.out.println("After reversal");
        display(head);
    }
}

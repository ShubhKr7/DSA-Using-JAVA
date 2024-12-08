/*
 160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:
The inputs to the judge are given as follows (your program is not given these inputs):
intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.

Example 2:
Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.

Example 3:
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

Constraints:
The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
1 <= m, n <= 3 * 10^4
1 <= Node.val <= 10^5
0 <= skipA <= m
0 <= skipB <= n

intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.

Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
 */

package leetcodeQuestions;

import java.util.ArrayList;

public class intersectionOfTwoLinkedList {
    
    //ListNode class
    static class ListNode{
        int val; ListNode next;
        ListNode(){}
        ListNode(int x){val=x;}
        ListNode(int x, ListNode n){val=x; next=n;}
    }

    //Bruteforce Way
    static ListNode inter(ListNode A, ListNode B){
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode p=A;

        //Store all the nodes of all the nodes in an arraylist
        while(p!=null){
            list.add(p);
            p=p.next;
        }

        //Now check is that particular node exists in the arraylist or not
        ListNode q=B;
        while(q!=null){

            //If yes then return that node
            if(list.contains(q)) return q;
            q=q.next;
        }

        //If not then return null
        return null;
    }

    //Optimised way
    static ListNode getInter(ListNode A, ListNode B){
        ListNode p=A; ListNode q=B;
        int a=0,b=0;

        //Find the size of first LinkedList
        while(p!=null){
            a+=1; p=p.next;
        }

        //Find the address of second arraylist
        while(q!=null){
            b+=1; q=q.next;
        }

        //If first linkedlist is greater than second then move first head till size of lists both become equal
        while(a>b){
            a-=1;
            A=A.next;
        }

        //If second linkedlist is greater than first then move second head till size of both lists become equal
        while(b>a){
            b-=1;
            B=B.next;
        }

        //Now iterate through the lists till a common node is found
        while(A!=B){
            A=A.next; B=B.next;
        }

        //If found then return that node or return null
        return A!=null?A:null;
    }

    //Creating a function to display the list
    public static void display(ListNode head){
        while(head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }

    //Main Function
    public static void main(String[] args) {
        ListNode C= new ListNode(500, new ListNode(6, new ListNode(7, new ListNode(8))));
        // ListNode A= new ListNode(1, new ListNode(2, new ListNode(3, C)));
        ListNode A= new ListNode(1, C);
        ListNode B= new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, C))));

        System.out.print("A:");
        display(A);

        System.out.print("B:");
        display(B);

        System.out.print("C:");
        display(C);

        ListNode res=inter(A,B);
        System.out.println(res!=null?res.val:"NULL");
    }
}

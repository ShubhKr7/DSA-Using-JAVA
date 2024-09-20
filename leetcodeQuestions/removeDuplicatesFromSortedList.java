package leetcodeQuestions;

import java.util.TreeSet;

public class removeDuplicatesFromSortedList {
    
    //Making a ListNode class
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    //Function to remove duplicates
    public static ListNode update(ListNode head){

        //Creating a hashset as it is maintains order of elements in ascending order
        TreeSet<Integer> set = new TreeSet<>();
        ListNode p=head;

        //Iterating over the list
        while(p!=null){
            set.add(p.val);
            p=p.next;
        }

        //Creating a new Linked List to return the updated list
        removeDuplicatesFromSortedList obj = new removeDuplicatesFromSortedList();
        ListNode dummyHead = obj.new ListNode();
        ListNode tail=dummyHead;
        for(Integer element : set){
            ListNode newNode = obj.new ListNode(element);
            tail.next=newNode;
            tail=tail.next;
        }

        //Retruning result
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

        //Making necessary objects
        removeDuplicatesFromSortedList obj = new removeDuplicatesFromSortedList();

        //Creating list
        // ListNode first = obj.new ListNode(1, obj.new ListNode(1, obj.new ListNode(1, obj.new ListNode(4, obj.new ListNode(5)))));
        // ListNode first = obj.new ListNode();
        ListNode first = obj.new ListNode(1, obj.new ListNode(1));
        System.out.println("Original list:");
        display(first);

        System.out.println("Duplicates removed list:");
        ListNode res=update(first);
        display(res);
    }
}

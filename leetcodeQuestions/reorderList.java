package leetcodeQuestions;
import java.util.*;

public class reorderList{

    //Creating class for ListNode
    class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    //Creating a function for reordering list
    public void reOrder(ListNode head){
        ListNode p=head;
        ArrayList<Integer> arr=new ArrayList<>();
        while(p!=null){
            arr.add(p.val);
            p=p.next;
        }
        int z=arr.size()-1;
        for(int i=0;i<=z;i+=1){

            //Inserting elements from left end
            head.val=arr.get(i);
            head=head.next;

            //Inserting elements from right end
            if(!(z<=i)){
            head.val=arr.get(z);
            head=head.next;
            z-=1;}
        }
    }
    
    //Creating a function to display the list
    public void display(ListNode head){
        while(head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {

        //Making object of parent class
        reorderList obj=  new reorderList();

        //Making object of subclass and assigning values to linked list
        ListNode list = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(3, obj.new ListNode(4, obj.new ListNode(5)))));

        //Printing original list
        System.out.println("Original List:");
        obj.display(list);

        //Reordering list
        obj.reOrder(list);

        //Displaying new list
        System.out.println("Reordered List:");
        obj.display(list);
    }
}
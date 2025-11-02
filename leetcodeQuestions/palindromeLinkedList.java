/*
234. Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true
Example 2:

Input: head = [1,2]
Output: false

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?
 */

package leetcodeQuestions;
import java.util.*;

public class palindromeLinkedList {
    static ListNode curr;

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode insert() {
        ListNode head = null;
        ListNode temp = null;
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == -1)
                break;
            ListNode node = new ListNode(n);
            if (head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = temp.next;
            }
        }
        in.close();
        return head;
    }

    public static void display(ListNode list) {
        while (list.next != null) {
            System.out.print(list.val + "->");
            list = list.next;
        }
        System.out.println(list.val);
    }

    public static boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        curr = head;
        return recur(head);
    }

    public static boolean recur(ListNode head) {
        if (head == null)
            return true;
        boolean res = recur(head.next) && (head.val == curr.val);
        curr = curr.next;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = insert();
        display(head);

        System.out.println(isPalindrome(head));
        display(head);
    }
}

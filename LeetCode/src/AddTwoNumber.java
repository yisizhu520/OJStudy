/**
 * Created by WangJun on 2016/9/19.
 * <pre>
 *     You are given two linked lists representing two non-negative numbers.
 *     The digits are stored in reverse order and each of their nodes contain
 *     a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * </pre>
 */
public class AddTwoNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode result = new Solution().addTwoNumbers(l1,l4);
        print(result);

    }

    static void print(ListNode node){
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode next(int value) {
            ListNode last = next;
            if (last == null) {
                next = new ListNode(value);
                return this;
            }
            while (last.next != null) {
                last = last.next;
            }
            last.next = new ListNode(value);
            return this;
        }

    }


    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode last = null;
            int value = 0;
            int extra = 0;
            while (l1 != null || l2 != null || extra != 0) {
                int val1 = 0, val2 = 0;
                if (l1 != null) {
                    val1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    val2 = l2.val;
                    l2 = l2.next;
                }
                value = val1 + val2 + extra;
                extra = 0;
                if (value > 9) {
                    value = value - 10;
                    extra = 1;
                }
                ListNode next = new ListNode(value);
                if (last == null) {
                    head = last = next;
                } else {
                    last.next = next;
                    last = last.next;
                }

            }
            return head;
        }
    }


}

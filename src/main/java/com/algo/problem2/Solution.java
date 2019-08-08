package com.algo.problem2;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum = getNumberFromListNode(l1, new StringBuilder()) + getNumberFromListNode(l2, new StringBuilder());
        ListNode res = getListNodeFromInt(sum);
        return res;
    }

    public static long getNumberFromListNode(ListNode listNode, StringBuilder stringBuilder) {
        if (listNode.next == null) {
            return Long.parseLong(stringBuilder.append(listNode.val).toString());
        }
        return getNumberFromListNode(listNode.next, stringBuilder.append(listNode.val));
    }

    public static ListNode getListNodeFromInt(long i) {
        ListNode start = new ListNode((int) (i % 10));
        ListNode first = start;
        while (i / 10 > 0) {
            i = i / 10;
            first.next = new ListNode((int) (i % 10));
            first = first.next;
        }
        return start;
    }
}

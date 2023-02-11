/*************************************************************     Problem Statement    *********************************************************************************/


You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
  
  
/*************************************************************     Solution    *********************************************************************************/
  
  
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public static ListNode findMid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        {
            System.out.println(head.val);
        }
        else
        {
            ListNode mid=findMid(head);
            ListNode head1=head;
            ListNode head2=reverse(mid.next);
            while(head2!=null)
            {
                ListNode next1=head1.next;
                ListNode next2=head2.next;
                head1.next=head2;
                head2.next=next1;
                head1=next1;
                head2=next2;
            }
            head1.next=null;
        }
    }
}

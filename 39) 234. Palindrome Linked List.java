/*************************************************************     Problem Statement    *********************************************************************************/


Given the head of a singly linked list, return true if it is a 
palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true
  
Example 2:

Input: head = [1,2]
Output: false
 
Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
  
  
/*************************************************************     Solution     *********************************************************************************/
  
  
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

    public static ListNode reverse(ListNode mid)
    {
        ListNode prev=null;
        ListNode curr=mid;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static ListNode findMid(ListNode head)
    {
        ListNode turtle=head;
        ListNode hare=head;
        while(hare.next!=null && hare.next.next!=null)
        {
            hare=hare.next.next;
            turtle=turtle.next;
        }
        return turtle;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
        {
            return true;
        }

        ListNode mid=findMid(head);

        ListNode head1=head;
        ListNode head2=reverse(mid.next);

        while(head2!=null)
        {
            if(head1.val!=head2.val)
            {
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }
}

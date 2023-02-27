/******************************************************************  Problem statement   *******************************************************************************/


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

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
  
  
/*********************************************************************  Solution   **********************************************************************************/
  
  
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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode mid=findMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);

        return merge(left,right);
    }

    public ListNode findMid(ListNode head)
    {
        ListNode turtle=head;
        ListNode hare=head;
        ListNode temp=null;
        while(hare!=null && hare.next!=null)
        {
            temp=turtle;
            turtle=turtle.next;
            hare=hare.next.next;
        }
        temp.next=null;
        return turtle;
    }

    public ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while(head1!=null && head2!=null)
        {
            if(head1.val<=head2.val)
            {
                curr.next=head1;
                head1=head1.next;
            }
            else
            {
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }
        curr.next=(head1!=null)? head1:head2;

        return dummy.next;
    }
}

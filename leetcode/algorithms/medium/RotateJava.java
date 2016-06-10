/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null)
            return head;
        
        int n = 1;
        ListNode ptr = head;
        
        while(ptr.next != null){
            ptr = ptr.next;
            n++;
        }
        
        ptr.next = head;
        n -= k % n;
        
        while(n > 0){
            ptr = ptr.next;
            n -= 1;
        }
        
        ListNode r = ptr.next;
        ptr.next = null;
        return r;
    }
}
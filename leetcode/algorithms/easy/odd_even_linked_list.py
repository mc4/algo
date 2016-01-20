class Solution(object):
    def oddEvenList(self, head):
        if head is None:
            return None
            
        if head.next is None or head.next.next is None:
            return head
            
        odd = head
        even = head.next
        even_head = head.next
        
        while even and even.next:
            odd.next = odd.next.next
            even.next = even.next.next
            
            odd = odd.next
            even = even.next
            
        odd.next = even_head
        
        return head
            
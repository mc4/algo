class Solution(object):
    def mergeTwoLists(self, l1, l2):
        ls = p = ListNode(0)
        
        while l1 and l2:
            if l1.val < l2.val:
                p.next = l1
                p = p.next
                l1 = l1.next
            else:
                p.next = l2
                p = p.next
                l2 = l2.next
                
        while l1:
            p.next = l1
            p = p.next
            l1 = l1.next
        
        while l2:
            p.next = l2
            p = p.next
            l2 = l2.next
            
        return ls.next
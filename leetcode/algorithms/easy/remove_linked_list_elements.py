# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        
        # empty list
        #if not head:
            #return None
            
        res = ptr = ListNode(0)
        res.next = head
        while ptr.next:
            if ptr.next.val == val:
                ptr.next = ptr.next.next
            else:
                ptr = ptr.next
    
        return res.next

# 63 / 63 test cases passed.
# Status: Accepted
# Runtime: 120 ms
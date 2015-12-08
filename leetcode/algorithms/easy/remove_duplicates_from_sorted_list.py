# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        if head:
            ptr = head.next
            while ptr and ptr.val == head.val:
                ptr = p.next
            head.next = self.deleteDuplicates(ptr)
            
        return head

# 164 / 164 test cases passed.
# Status: Accepted
# Runtime: 56 ms
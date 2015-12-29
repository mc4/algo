class Solution(object):
    def detectCycle(self, head):
        
        finder = slow = fast = head
        
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            
            if slow == fast:
                while finder != slow:
                    slow = slow.next
                    finder = finder.next
                return finder
                     
        return None
        
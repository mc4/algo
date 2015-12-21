class Solution(object):
    def hasCycle(self, head):
        
        ''' Floyd's cycle-finding algorithm '''
        
        if not head:
            return False
            
        slow = fast = head

        while True:
            slow = slow.next
            
            if fast.next != None:
                fast = fast.next.next
            else:
                return False # end of list, so no loop
                
            if slow == None or fast == None: # end of list, so no loop
                return False
            
            if slow == fast: # if two ever meet, must have loop
                return True
                
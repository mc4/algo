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
                


# A few other ways to do this:
#     1. Assuming you can manipulate values of the list and that each 
#         node has valid value other than None, 
            
#             while head
#                 if head.val == None
#                     return True
#                 head.val = None
#                 head = head.next
#             return False


#         This seems faster, but theres alot of assumptions. 
#     2. This might be slightly faster

#             slow = fast = head
#             while fast and fast.next:
#                 fast = fast.next.next
#                 slow = slow.next
#                 if slow == fast:
#                     return True
#             return False

#     3. Fastest?
#             if head is None: return False
#             slow, fast = head, head.next
#             while slow != fast
#                 if slow is None or fast.next is None: return False
#                 slow = slow.next
#                 fast = fast.next.nest
#             return True


class Solution(object):
    def getIntersectionNode(self, headA, headB):
        
        if headA is None or headB is None:
            return None
            
        a, b = headA, headB
        
        while a != b:
            
            a = a.next if a != None else headB
            b = b.next if b != None else headA
        
        return a
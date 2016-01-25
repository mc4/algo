class Solution(object):
    def removeNthFromEnd(self, head, n):
        ptr = chaser = r = ListNode(0)
        r.next = head
        
        for _ in xrange(n):
            ptr = ptr.next
        while ptr.next != None:
            chaser, ptr = chaser.next, ptr.next
        chaser.next = chaser.next.next
        return r.next

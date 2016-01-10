class Solution(object):
    def isPalindrome(self, head):
        if not head:
            return True
            
        p, s = head, []
        
        while p:
            s.append(p.val)
            p = p.next
            
        return s == s[::-1]
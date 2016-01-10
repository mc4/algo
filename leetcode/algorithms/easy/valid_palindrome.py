class Solution(object):
    def isPalindrome(self, s):
        
        front = 0
        back = len(s)-1
        s = s.lower()
        
        while front <= back:
            
            if not s[front].isalnum():
                front += 1
                continue
            
            elif not s[back].isalnum():
                back -= 1
                continue
            
            if s[front] != s[back]:
                print s[front], s[back]
                return False
                
            front += 1      
            back -= 1
            
        return True

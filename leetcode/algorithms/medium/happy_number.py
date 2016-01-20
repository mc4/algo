class Solution(object):
    def isHappy(self, n):
        
        d = {}
        while (n != 1):
            
            if n in d:
                return False
                
            d[n] = 1
            total = 0
            while(n != 0):
                total += (n%10)*(n%10)
                n = n/10
                
            n = total
            
        return True
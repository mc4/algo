class Solution(object):
    def trailingZeroes(self, n):
        
        c, i = 0, 5
        while n/i >= 1:
            c += n/i
            i *= 5
            
        return c
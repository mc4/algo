from string import ascii_uppercase as alphabet

class Solution(object):
    def titleToNumber(self, s):

        if s:
            d = dict(zip(alphabet, xrange(1,27)))
            l, res = len(s), 0
            
            for i,e in enumerate(s, 1):
                res = res + 26 ** (l - i) * (d[e]) 
                
            return res      
            
        return 0
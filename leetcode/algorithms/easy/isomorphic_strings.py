class Solution(object):
    def isIsomorphic(self, s, t):
        if len(s) != len(t): 
            return False
        
        d = dict(zip(s,t))
        values = d.values()
        
        if sorted(list(set(values))) != sorted(values):
            return False
        
        for i, e in enumerate(s):
            if d[e] != t[i]:
                return False
                
        return True
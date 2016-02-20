class Solution(object):
    def wordPattern(self, pattern, str):
        
        words = str.split()
        
        if len(pattern) != len(words):
            return False        
        
        d = {}
        
        for c, w in zip(pattern, words):
            if c in d:
                if d[c] != w:
                    return False
                    
            if w in d.values() and c not in d:
                return False
                
            d[c] = w
            
        return True
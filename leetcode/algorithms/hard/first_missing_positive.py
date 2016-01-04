class Solution(object):
    def firstMissingPositive(self, nums):
        
        if not nums:
            return 1
            
        ls = sorted(set(nums))
        ls = [x for x in ls if x > 0]
        
        if not ls or:
            return 1
            
        if ls[0] != 1:
            return 1
            
        for i in xrange(len(ls)-1):
            e = ls[i]+1
            if ls[i+1] != e:
                return e
                
        return ls[-1]+1
class Solution(object):
    def findDuplicate(self, nums):
        
        c = sorted(nums)
        
        for i in xrange(len(c)):
            if c[i] == c[i+1]:
                return c[i]

class Solution(object):
    def twoSum(self, nums, target):
        d = {}
        
        for i in xrange(len(nums)):
            x = nums[i]
            if target - x in d:
                return [d[target - x ] + 1, i + 1]
            d[x] = i
class Solution(object):
    def missingNumber(self, nums):
        
        l = len(nums)
        
        if l == 1:
            return 1 if nums[0] == 0 else 0
            
        n = 0
        nums.sort()
        
        for num in nums:
            if num != n:
                return n
                
            n += 1
            
        return l
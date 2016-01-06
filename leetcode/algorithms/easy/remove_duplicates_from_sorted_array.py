class Solution(object):
    def removeDuplicates(self, nums):
        
        if nums:
            nums[:] = list(set(nums))
            nums.sort()
            return len(nums)
        else:
            return 0
            
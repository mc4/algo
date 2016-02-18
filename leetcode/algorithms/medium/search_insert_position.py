class Solution(object):
    def searchInsert(self, nums, target):
    	
        if target < nums[0]:
            return 0        
        elif target > nums[-1]:
            return len(nums)
            
        for index, num in enumerate(nums):
            if target == num:
                return index
            elif target > num and target < nums[index+1]:
                return index + 1
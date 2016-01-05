class Solution(object):
    def maxSlidingWindow(self, nums, k):
        if not nums:
            return nums
            
        res = []
        
        while len(nums) >= k:
            res.append(max(nums[:k]))
            nums.pop(0)
        
        return res

       	# return [max(nums[i:i+k]) for i in xrange(len(nums)-k+1)]
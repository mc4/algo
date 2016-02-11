class Solution(object):
    def rotate(self, nums, k):

        if k > len(nums):
            k = k % len(nums)
            
        if nums:
            nums[:] = nums[-k:] + nums[:-k]
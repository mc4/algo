class Solution(object):
    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums) < 2:
            return 0

        nums = sorted(nums)
        if len(nums) == 2:
            return nums[1]-nums[0]

        return max([(nums[i+1] - nums[i]) for i in xrange(1, len(nums)-1)])

# 17 / 17 test cases passed.
# Runtime: 48 ms
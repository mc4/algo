class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        s = set(nums)
    	for n in s:
    		if nums.count(n) > len(nums)/2:
    			return n
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        #submitted - time limit exceeded
        '''
        s = set(nums)
        for num in s:
        	if nums.count(num) == 1:
        		return num
        '''

        s = set()
        for e in nums:
        	if e not in s:
        		s.add(e)
        	else:
        		s.remove(e)
        return list(s)[0]
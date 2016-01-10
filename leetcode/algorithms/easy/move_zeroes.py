class Solution(object):
    def moveZeroes(self, nums):

    	# Algorithm 1 runs much faster

    	j, l = 0, len(nums)
        
        for i in xrange(l):
            if nums[i] != 0:
                nums[j] = nums[i]
                j += 1
        
        for i in xrange(j, l):
            nums[i] = 0

        # # Algorithm 2

        # for i, n in enumerate(nums[1:], start = 1):
        #     if n == 0:
        #         continue
            
        #     j = i
        #     while j > 0 and nums[j-1] == 0:
        #         j -= 1
                
        #     nums[i], nums[j] = 0, n    
        
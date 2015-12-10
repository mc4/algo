class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n != 0 and ((n & (n - 1)) == 0)
        
# 1108 / 1108 test cases passed.
# Status: Accepted
# Runtime: 60 ms
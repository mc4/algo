class Solution(object):
    def canWinNim(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n > 0 and n % 4 != 0


# 60 / 60 test cases passed.
# Status: Accepted
# Runtime: 44 ms
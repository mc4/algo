class Solution(object):
    def climbStairs(self, n):
        a, b = 1, 2
        for i in xrange(n-1):
            a, b = b, a + b
        return a
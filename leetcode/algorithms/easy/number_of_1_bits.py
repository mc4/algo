class Solution(object):
    def hammingWeight(self, n):
        return bin(n).count('1')
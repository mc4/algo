class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
    
        return sorted(s) == sorted(t)

# 32/32 test cases passed
# Runtime: 96 ms
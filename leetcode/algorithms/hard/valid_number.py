class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """

        try:
            float(s)          
            return True
        except:
            return False

# 1481/1481 test cases passed
# Runtime: 84 ms 
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num == 0:
            return 0
        #digit root 
        return 1 + ((num - 1) % 9)

# 1101/1101 
# 64 ms
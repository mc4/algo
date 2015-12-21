class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """

		words = s.split()      
        if not words:
            return 0
        return len(words[-1]) # faster than 64.50% of Python submissions

        # return len(words[-1]) if len(words) else 0 # faster than 2.96% of Python submissions. 
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        #return 1 + int( ''.join(digits) )
        return [ 1 + int(filter(str.isdigit, repr(digits))) ]
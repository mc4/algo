class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        #return 1 + int( ''.join(digits) )
        #return list(str(1 + int(filter(str.isdigit, repr(digits))) ))
        return [int(x) for x in str(1 + int(''.join(map(str, digits))))]
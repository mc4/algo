class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        
        nums.sort() # speeds it up

        # removes all occurences of val in place
        while True:
            try:
                nums.remove(val)
            except:
                break
        
        return len(nums)
        
        
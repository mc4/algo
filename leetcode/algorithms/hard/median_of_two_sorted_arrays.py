class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
   
        nums1.extend(nums2)
        nums1.sort()
        l = len(nums1)
        
        if l == 1:
            return nums1[0]
            
        return nums1[l/2] if l%2 else (nums1[(l/2)-1] + nums1[l/2])/2.0
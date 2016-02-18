class Solution(object):
    def summaryRanges(self, nums):
        
        def process(start,end):
            scope = ''
            if start == end:
                scope = str(start)
            else:
                scope = '->'.join([str(start),str(end)])
                
            return scope

        
        if not nums:
            return []
         
        start = end = nums[0]
        res = []
        
        for i, n in enumerate(nums[1:], 1):
            
            if nums[i] - nums[i-1] == 1:
                end = n
            else:
                res.append(process(start, end))
                start = end = n
               
        
        res.append(process(start, end))
        return res
                
                
class Solution(object):
    def generate(self, numRows):
        
        res = []
        
        for i in xrange(1, numRows+1):
            row, rowLen, step = [], i, 0
                
            while rowLen > 0:
                if rowLen == i or rowLen == 1:
                    row.append(1)
                else:
                    val = sum(res[i-2][step:step+2])
                    row.append(val)
                    step += 1 
                    
                rowLen -= 1
                    
            res.append(row)
            
        return res
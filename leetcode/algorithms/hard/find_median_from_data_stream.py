from bisect import insort

class MedianFinder:
    def __init__(self):
        self.ls = []
        self.l = 0

    def addNum(self, num):
        insort(self.ls, num)
        self.l += 1

    def findMedian(self):
        if self.l == 2:
            return float((self.ls[0] + self.ls[1])) / 2
            
        i = self.l / 2  
        
        if self.l % 2:  
            return float(self.ls[i])
        
        return float(sum(self.ls[i-1:i+1])) / 2
            
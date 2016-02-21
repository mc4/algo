from bisect import insort
# import operator



ls = [1,2,3]

def step(ls):
	ls = [i**2 for i in ls]
	print ls
	
print ls
step(ls)
print ls		

# class Interval(object):
# 	def __init__(self, s=0, e=0):
# 		self.start = s
# 		self.end = e


# # class Solution:

# #     def insert(self, intervals, newInterval):
# #         i = bisect.bisect([e.start for e in intervals], newInterval.start)
# #         intervals.insert(i, newInterval)
# #         return self.merge(intervals)

# #     def merge(self, intervals):
# #         if len(intervals) < 2:
# #             return intervals
# #         intervals = sorted(intervals, key=operator.attrgetter('start'))
# #         res = []
# #         s, e = intervals[0].start, intervals[0].end
# #         for interval in intervals:
# #             if interval.start <= e:
# #                 e = max(e, interval.end)
# #             else:
# #                 res.append(Interval(s, e))
# #                 s, e = interval.start, interval.end
# #         res.append(Interval(s, e))
# #         return res

# pre = [[1,2],[3,5],[6,7],[8,10],[12,16]]
# intervals = [ Interval(i[0],i[1]) for i in pre ]

# # newInterval = [4,9]
# newInterval = Interval(4,9)


# # i = bisect.bisect([e.start for e in intervals], newInterval.start)
# # print i

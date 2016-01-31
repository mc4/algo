import sys
from bisect import bisect_left

edges = [0, 2, 4, 6]
priority = ["Done", "Low", "Medium", "High", "Critical"]

def bug_counter(test, design):
	return sum( test[i] != design[i] for i in xrange(len(test)) )

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		testing, actual = test.strip().split(' | ')
		bugs = bug_counter(testing, actual)
		print priority[bisect_left(edges, bugs)]



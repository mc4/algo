import sys

def arrow_count(c):
	return sum(c[i:i+5] == '>>-->' or c[i:i+5] == '<--<<' for i in xrange(len(c)-4))

	'''
	#This also works but is less pythonic
	s = 0
	for i in xrange(len(c)-4):
		if c[i:i+5] == '>>-->' or c[i:i+5] == '<--<<':
			s += 1
	return s
	'''

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print arrow_count(test.strip())

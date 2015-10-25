import sys
from itertools import groupby

def compressor(ls):
	res = ''
	for k,g in groupby(ls):
		res += '{} {} '.format(len(list(g)), k)
	return res


with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print compressor(test.strip().split())
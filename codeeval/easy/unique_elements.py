import sys

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		ls = sorted([int(x) for x in set(test.strip().split(','))])
		print ','.join(str(c) for c in ls)
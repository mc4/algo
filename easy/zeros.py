import sys

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		target, scope = map(int, test.strip().split())
		print sum(str(bin(i)[2:]).count('0') == target for i in xrange(1, scope+1))
import sys

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		n, p1, p2 = map(int, test.strip().split(','))
		n = list(bin(n))
		n.reverse()
		print 'true' if n[p1-1] == n[p2-1] else 'false'

import sys

def valid(n, ls):
	e = range(1, n+1)
	for i in xrange(n):
		if e != sorted(ls[::n]):
			return False
	return True

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		n, ls = test.strip().split(';')
		print valid(int(n), map(int, ls.split(',')))
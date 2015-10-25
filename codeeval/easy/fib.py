import sys

def fib(n):
 	a, b = 1, 1
	for i in xrange(n-1):
		a, b = b, a+b
	return a

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print fib(int(test.strip()))
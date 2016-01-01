import sys

def total(n):
	return sum(2 * int(e) if i % 2 == 0 else int(e) for i, e in enumerate(n))

def is_valid(l):
	return total(l) % 10 == 0

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print 'Real' if is_valid(test.strip().replace(' ', '')) else 'Fake'


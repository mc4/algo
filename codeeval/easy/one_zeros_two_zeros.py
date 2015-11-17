import sys

def count_zeros(target, limit):
	return len([x for x in range(1, limit+1) if bin(x)[2:].count('0') == target])

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		target, limit = [int(x) for x in test.strip().split()]
		print(count_zeros(target, limit))
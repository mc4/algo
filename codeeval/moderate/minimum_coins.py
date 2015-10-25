import sys

def minimum(n):
	count = 0
	while n > 0:
		if n >= 5:
			n -= 5
			count += 1
		elif n >= 3:
			n -= 3
			count += 1
		elif n == 2:
			n -= 2
			count += 2
		else:
			n -= 1
			count += 1
	return count

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print minimum(int(test.strip()))
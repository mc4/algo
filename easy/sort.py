import sys 

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print ' '.join(map(lambda i: '%.3f' % i, sorted(map(float, test.strip().split()))))
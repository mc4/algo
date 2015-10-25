import sys

def highest(scores, offset):
	res = []
	for i in xrange(offset):
		res.append(max(scores[i::offset]))
	return ' '.join(str(x) for x in res)

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		n, m = test.strip().split(' | '), []
		for i in xrange(len(n)):
			m += n[i].split()

		print highest(map(int, m), len(n[0].split()))

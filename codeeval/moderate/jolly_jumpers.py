import sys

def jolly(ls):
	diff, res = len(ls), set()
	for i in xrange(len(ls)-1):
		diff = abs(ls[i] - ls[i+1])
		if diff >= len(ls) or diff == 0 or diff in res:
			return False
		else:	
			res.add(diff)
	return True

	#if sorted(res) == list(xrange(1, len(ls))):
	#	return True
	#return False

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		seq = map(int, test.strip().split()[1:])
		print 'Jolly' if jolly(seq) else 'Not Jolly'
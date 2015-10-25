import sys

with open(sys.argv[1], 'r') as testcases:
	for test in testcases:
		string, trail = test.strip().split(',')
		if len(trail) > len(string): 
			print 0
			continue
		offset = len(string) - len(trail)

		if string[offset:] == trail:
			print 1
		else:
			print 0

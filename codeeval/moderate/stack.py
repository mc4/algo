import sys 

with open(sys.argv[1], 'r') as testcases:
	for test in testcases:
		print ' '.join(list(test.strip().split())[::-1][0::2])

import sys

with open(sys.argv[1],'r') as testcases:
	for test in testcases:	
		print max(test.strip().split(), key=len)

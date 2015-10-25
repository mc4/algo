import sys

with open(sys.argv[1], 'r') as tc:
	for t in tc:
		print sum([int(c) for c in t.strip()])

import sys
import re

def distance_from(x,y):
	return int(((y[0]-x[0])**2 + (y[1]-x[1])**2)**0.5)

with open(sys.argv[1], 'r') as testcases:
	for test in testcases:
		ns = re.findall('-*\d+', test.strip())
		if ns:
			ns = map(int, ns)
			print distance_from(ns[:2],ns[-2:])

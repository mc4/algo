import sys

def unique(w):
	for c in w:
		if 1 == w.count(c):
			return c

with open(sys.argv[1], 'r') as tc:
	for t in tc:
		print unique(t.strip())
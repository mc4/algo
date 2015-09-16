import sys
from string import ascii_lowercase as lc

with open(sys.argv[1], 'r') as tc:
	for t in tc:
		res = ''
		for c in t:
			if c.islower() and lc.index(c) < 10:
				res += str(lc.index(c))
			elif c.isdigit():
				res += str(c)

		print res if len(res) != 0 else 'NONE'

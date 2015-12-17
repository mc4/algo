import sys
from math import factorial

def curious(x):
	return True if sum(factorial(int(n)) for n in str(x)) == x else False

total = 0
for i in xrange(3, sys.maxint):
	if curious(i):
		total += i

print total
import sys
from math import factorial

def curious(x):
	return x == sum(factorial(int(n)) for n in str(x))

total = 0
for i in xrange(3, sys.maxint):
	if curious(i):
		total += i

print total
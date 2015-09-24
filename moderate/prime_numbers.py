import sys

def is_prime(a):
    return all(a % i for i in xrange(2, a))

def cpl(m):
	l = []
	[l.append(str(x)) for x in xrange(2,m) if is_prime(x)]
	return l
	
with open(sys.argv[1], 'r') as tc:
	for t in tc:
		print ','.join(cpl(int(t.strip())))

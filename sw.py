import sys

def g(ls):
	lw=''
	for i in xrange(len(ls)):
		if len(ls[i]) == len(lw):
			continue
		if len(ls[i]) > len(lw):
			lw = ls[i]
	return lw

def p(w):
	sc=0
	rw=''
	for i in xrange(len(w)):
		for j in xrange(sc):
			rw += '*'
		rw += w[i] + ' '
		sc += 1
	return rw

with open(sys.argv[1], 'r') as tc:
	for t in tc:
		print p(g(t.split()))
		

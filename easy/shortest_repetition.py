import sys

def repitions(seq):

	b = seq.strip()[0]
	l = t[1:].find(b)

	#return l
	if 0 == l:
		return 1
	elif l > 0:
		return l+1

	return len(seq)


with open(sys.argv[1], 'r') as tc:
	for t in tc:
		print repitions(t.strip())
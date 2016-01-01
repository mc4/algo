import sys

def armstrong(n):
	l = len(n)
	return sum([int(i)**l for i in n[:l]]) == int(n)


with open(sys.argv[1], 'r') as tc:
	for t in tc:
		print armstrong(t.strip())

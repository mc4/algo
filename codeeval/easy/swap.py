import sys

def swap(ls, s, v):
	t = ls[s]
	ls[s] = ls[v]
	ls[v] = t
	
	return ls

def parser(line):
	elements, swaps = line.split(':')
	elements = elements.strip().split()
	swaps = swaps.strip().split(',')
	swaps = [tuple(map(int, e.strip().split('-'))) for e in swaps]

	return elements, swaps


with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		ls, swaps = parser(test.strip())
		for s in swaps:
			ls = swap(ls, s[0], s[1])
		print ' '.join(ls)
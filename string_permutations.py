import itertools, sys

with open(sys.argv[1], 'r') as testcases:
	for test in testcases:
		if len(test) == 0: 
			continue
			
		perm_list = []
		permutations = itertools.permutations(list(test.strip()))
		for perm in permutations:
			perm_list.append(''.join(perm))
		perm_list.sort()
		print ','.join(perm_list)

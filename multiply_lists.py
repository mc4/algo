import sys

with open(sys.argv[1], 'r') as testcases:
	for test in testcases:
		left, right = test.strip().split(' | ')

		left = [int(x) for x in left.split()]
		right = [int(x) for x in right.split()]

		for i in xrange(len(left)): #size of left and right should be equal
			print left[i] * right[i],
		print

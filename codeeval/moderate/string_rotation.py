import sys

def is_rotation(s1, s2):
	return len(s1) == len(s2) and s2 in s1+s1

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		s1, s2 = test.strip().split(',')
		print is_rotation(s1,s2)

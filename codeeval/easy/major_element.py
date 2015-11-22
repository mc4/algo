import sys

def find_major_element(ls, s):
	major = None
	for n in s:
		if ls.count(n) > len(ls)/2:
			major = n

	return major

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		ls = test.strip().split(',')
		print(find_major_element(ls, set(ls)))

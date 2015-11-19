import sys

with open(sys.argv[1], 'r') as test_cases:	
	for test in test_cases:
		test, res = test.strip(), test[0]
		for index, char in enumerate(test):
			if index == 0:
				continue
			if char != test[index - 1]:
				res += char
		print(res)
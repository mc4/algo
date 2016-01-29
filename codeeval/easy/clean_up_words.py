import sys

def clean(line):
	res = ''
	for char in line:
		if char.isalpha():
			res += char.lower()
		else:
			if res and res[-1].isspace() is False:
					res += ' '

	return res

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print clean(test.strip())
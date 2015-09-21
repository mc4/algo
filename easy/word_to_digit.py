import sys

with open(sys.argv[1], 'r') as testcases:

	word_digit = { 'zero': '0', 'one': '1','two': '2', 'three': '3', 'four': '4', 
				   'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9' }
	for test in testcases:
		words = test.strip().split(';')
		res = ''
		for word in words:
			res += word_digit[word]

		print res

import sys

def is_palindrome(value):

	letters = str(value)
	length = len(letters)

	if(length == 0 or length == 1):
		return True

	start, last = 0, length - 1

	if(letters[start] == letters[last]):
		return is_palindrome(letters[start+1:last])
	
	return False

with open(sys.argv[1], 'r') as testcases:
	for test in testcases:

		count, total = 1, int(test.strip()) + int(''.join(reversed(test.strip())))

		while True:
			if(is_palindrome(total)):
				break

			digit = total
			rev = int(''.join(reversed(str(digit))))
			total = digit + rev
			count += 1

		print count, total
		

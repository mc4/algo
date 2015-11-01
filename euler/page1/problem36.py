def slow_is_palindrome(s):
	return s == ''.join(reversed(s)) #slower	

def is_palindrome(s):
	'''fastest palindrome check'''
	return s == s[::-1] #fastest

total = 0
for x in xrange(1000000):
	if is_palindrome(str(x)) and is_palindrome(bin(x)[2:]):
		total += x

print total #872187